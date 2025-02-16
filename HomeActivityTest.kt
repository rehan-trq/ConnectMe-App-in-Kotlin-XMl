package com.RehanTariq.i220965

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    // Launches MainActivity before each test
    @get:Rule
    val activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun buttonClick_opensProfileScreen() {
        // 1. Click on the button that navigates to ProfileActivity
        onView(withId(R.id.nav_profile)).perform(click())

        // 2. Check if a view from ProfileActivity is displayed
        //    e.g., a TextView with ID tvProfileTitle
        onView(withId(R.id.tvProfileName)).check(matches(isDisplayed()))
    }
}
