package com.inved.freezdge

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.inved.freezdge.ingredientslist.ui.MyGroceryListActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class GroceryListActivityTest {

    @get:Rule
    val mActivityTestRule = ActivityTestRule(MyGroceryListActivity::class.java)

    @Test
    fun groceryActivityTest() {
        val compoundButton = Espresso.onView(
            Matchers.allOf(
                childAtPosition(
                    Matchers.allOf(
                        ViewMatchers.withId(R.id.chipGroup),
                        childAtPosition(
                            IsInstanceOf.instanceOf(RelativeLayout::class.java),
                            0
                        )
                    ),
                    10
                ),
                ViewMatchers.isDisplayed()
            )
        )
        compoundButton.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

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