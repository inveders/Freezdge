package com.inved.freezdge

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.inved.freezdge.uiGeneral.activity.MainActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    val mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {

        val frameLayout = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.activity_main_bottom_navigation),
                childAtPosition(
                    Matchers.allOf(
                        ViewMatchers.withId(R.id.mainContainer),
                        childAtPosition(
                            ViewMatchers.withId(R.id.activity_main_drawer_layout),
                            0
                        )
                    ),
                    2
                ),
                ViewMatchers.isDisplayed()
            )
        )
        frameLayout.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


        val bottomNavigationItemView = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.action_to_my_ingredients_list_fragment),
                ViewMatchers.withContentDescription("Ingredients"),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(R.id.activity_main_bottom_navigation),
                        0
                    ),
                    0
                ),
                ViewMatchers.isDisplayed()
            )
        )
        bottomNavigationItemView.perform(ViewActions.click())


        val appCompatImageButton3 = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withContentDescription("Open navigation drawer"),
                childAtPosition(
                    Matchers.allOf(
                        ViewMatchers.withId(R.id.toolbar),
                        childAtPosition(
                            ViewMatchers.withId(R.id.mainContainer),
                            0
                        )
                    ),
                    1
                ),
                ViewMatchers.isDisplayed()
            )
        )
        appCompatImageButton3.perform(ViewActions.click())

        val navigationMenuItemView = Espresso.onView(
            Matchers.allOf(
                childAtPosition(
                    Matchers.allOf(
                        ViewMatchers.withId(R.id.design_navigation_view),
                        childAtPosition(
                            ViewMatchers.withId(R.id.activity_main_nav_view),
                            0
                        )
                    ),
                    1
                ),
                ViewMatchers.isDisplayed()
            )
        )
        navigationMenuItemView.perform(ViewActions.click())

        val appCompatImageButton4 = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withContentDescription("Navigate up"),
                childAtPosition(
                    Matchers.allOf(
                        ViewMatchers.withId(R.id.toolbar),
                        childAtPosition(
                            ViewMatchers.withClassName(Matchers.`is`("android.widget.LinearLayout")),
                            0
                        )
                    ),
                    1
                ),
                ViewMatchers.isDisplayed()
            )
        )
        appCompatImageButton4.perform(ViewActions.click())

        Espresso.pressBack()

        val bottomNavigationItemView2 = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.action_to_all_recipes_fragment),
                ViewMatchers.withContentDescription("Recipes"),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(R.id.activity_main_bottom_navigation),
                        0
                    ),
                    2
                ),
                ViewMatchers.isDisplayed()
            )
        )
        bottomNavigationItemView2.perform(ViewActions.click())


        val appCompatImageButton5 = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withContentDescription("Open navigation drawer"),
                childAtPosition(
                    Matchers.allOf(
                        ViewMatchers.withId(R.id.toolbar),
                        childAtPosition(
                            ViewMatchers.withId(R.id.mainContainer),
                            0
                        )
                    ),
                    1
                ),
                ViewMatchers.isDisplayed()
            )
        )
        appCompatImageButton5.perform(ViewActions.click())

        val navigationMenuItemView2 = Espresso.onView(
            Matchers.allOf(
                childAtPosition(
                    Matchers.allOf(
                        ViewMatchers.withId(R.id.design_navigation_view),
                        childAtPosition(
                            ViewMatchers.withId(R.id.activity_main_nav_view),
                            0
                        )
                    ),
                    1
                ),
                ViewMatchers.isDisplayed()
            )
        )
        navigationMenuItemView2.perform(ViewActions.click())

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