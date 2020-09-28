package id.ac.ui.cs.mobileprogramming.prissy.helloworld

import id.ac.ui.cs.mobileprogramming.prissy.helloworld.R
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.core.StringStartsWith.startsWith
import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    @Test
    fun test_isButton_andTextInput_inView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.greetme)).check(matches(isDisplayed()))
        onView(withId(R.id.name_input)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isAble_toGreet() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.name_input)).perform(typeText("Prissy"), closeSoftKeyboard())
        onView(withId(R.id.fancy)).perform(click())
        onView(withId(R.id.greetme)).perform(click())
        onView(withId(R.id.greetName)).check(matches(withText("Salutations, Prissy!")))
    }
}