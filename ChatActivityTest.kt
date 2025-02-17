package com.example.yourapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.RehanTariq.i220965.ChatActivity
import com.RehanTariq.i220965.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ChatActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(ChatActivity::class.java)

    @Test
    fun clickCallButton_opensCallScreen() {
        onView(withId(R.id.buttonCall)).perform(click())
        onView(withId(R.id.textViewCallerName)).check(matches(isDisplayed()))
    }

}
