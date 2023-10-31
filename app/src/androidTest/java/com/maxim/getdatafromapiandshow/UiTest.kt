package com.maxim.getdatafromapiandshow

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.maxim.getdatafromapiandshow.presenatiton.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UiTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test() {
        onView(withText("Get fact")).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("fact1")))
        onView(withText("Get fact")).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("fact2")))
    }
}