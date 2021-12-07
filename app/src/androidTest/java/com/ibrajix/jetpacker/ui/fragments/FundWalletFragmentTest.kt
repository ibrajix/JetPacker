package com.ibrajix.jetpacker.ui.fragments

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.ibrajix.extension.launchFragmentInHiltContainer
import com.ibrajix.jetpacker.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

@HiltAndroidTest
class FundWalletFragmentTest{

    @get:Rule(order = 0)
    var hiltAndroidRule = HiltAndroidRule(this)

    @Before
    fun setUp(){
        hiltAndroidRule.inject()
    }

    @Test
    fun testThatOnClickBackButtonGoesBack(){
        val navController = Mockito.mock(NavController::class.java)
        launchFragmentInHiltContainer<FundWalletFragment>{
            Navigation.setViewNavController(requireView(), navController)
        }
        Espresso.onView(ViewMatchers.withId(R.id.ic_back)).perform(ViewActions.click())
        Mockito.verify(navController).popBackStack()
    }
}