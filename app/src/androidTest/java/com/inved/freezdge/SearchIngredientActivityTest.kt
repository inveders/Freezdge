package com.inved.freezdge

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.inved.freezdge.ingredientslist.ui.SearchIngredientsActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class SearchIngredientActivityTest {

    @get:Rule
    val mActivityTestRule = ActivityTestRule(SearchIngredientsActivity::class.java)

    @Test
    fun searchIngredientActivityTest() {



        val appCompatImageView = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.search_button),
                ViewMatchers.withContentDescription("Search"),
                childAtPosition(
                    Matchers.allOf(
                        ViewMatchers.withId(R.id.search_bar),
                        childAtPosition(
                            ViewMatchers.withId(R.id.searchItem),
                            0
                        )
                    ),
                    1
                ),
                ViewMatchers.isDisplayed()
            )
        )
        appCompatImageView.perform(ViewActions.click())


    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}