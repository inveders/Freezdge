package com.inved.freezdge

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.inved.freezdge.onboarding.OnboardingActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class OnboardingActivityTest {

    @get:Rule
    val mActivityTestRule = ActivityTestRule(OnboardingActivity::class.java)

    @Test
    fun onboardingActivityTest() {

        val materialButton2 = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.buttonOnboardingAction), ViewMatchers.withText("Next"),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(android.R.id.content),
                        0
                    ),
                    0
                ),
                ViewMatchers.isDisplayed()
            )
        )
        materialButton2.perform(ViewActions.click())

        val materialButton3 = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.buttonOnboardingAction), ViewMatchers.withText("Next"),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(android.R.id.content),
                        0
                    ),
                    0
                ),
                ViewMatchers.isDisplayed()
            )
        )
        materialButton3.perform(ViewActions.click())

        val materialButton4 = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.buttonOnboardingAction), ViewMatchers.withText("Next"),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(android.R.id.content),
                        0
                    ),
                    0
                ),
                ViewMatchers.isDisplayed()
            )
        )
        materialButton4.perform(ViewActions.click())

        val materialButton5 = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.buttonOnboardingAction), ViewMatchers.withText("Start"),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(android.R.id.content),
                        0
                    ),
                    0
                ),
                ViewMatchers.isDisplayed()
            )
        )
        materialButton5.perform(ViewActions.click())
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