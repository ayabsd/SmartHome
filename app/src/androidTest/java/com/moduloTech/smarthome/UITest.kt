package com.moduloTech.smarthome

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.google.android.material.slider.Slider
import com.moduloTech.smarthome.ui.ListDevices.holder.LightViewHolder
import com.moduloTech.smarthome.ui.MainActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class UITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun test_isListFragmentVisible_onAppLaunch() {
        Espresso.onView(ViewMatchers.withId(R.id.device_rv))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun click_on_recycle_item_navigate_to_index_and_action_on_slider() {
        Espresso.onView(ViewMatchers.withId(R.id.all_action)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.device_rv)).perform(ViewActions.swipeUp())

        Espresso.onView(ViewMatchers.withId(R.id.device_rv))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<LightViewHolder>(
                    5,
                    ViewActions.click()
                )

            )

        Espresso.onView(ViewMatchers.withId(R.id.device_light_silder)).perform(setValue(2.0F))
        Espresso.onView(ViewMatchers.withId(R.id.device_light_silder)).perform(setValue(10.0F))
        Espresso.onView(ViewMatchers.withId(R.id.device_light_silder))
            .check(ViewAssertions.matches(withValue(10.0F)))


    }


    private fun withValue(expectedValue: Float): Matcher<View?> {
        return object : BoundedMatcher<View?, Slider>(Slider::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("expected: $expectedValue")
            }

            override fun matchesSafely(slider: Slider?): Boolean {
                return slider?.value == expectedValue
            }
        }
    }

    fun setValue(value: Float): ViewAction {
        return object : ViewAction {
            override fun getDescription(): String {
                return "Set Slider value to $value"
            }

            override fun getConstraints(): Matcher<View> {
                return ViewMatchers.isAssignableFrom(Slider::class.java)
            }

            override fun perform(uiController: UiController?, view: View) {
                val seekBar = view as Slider
                seekBar.value = value
            }
        }
    }

}
