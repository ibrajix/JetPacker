package com.ibrajix.jetpacker.ui.fragments

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.ibrajix.extension.launchFragmentInHiltContainer
import com.ibrajix.jetpacker.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


@HiltAndroidTest
class HomeFragmentTest{

    @get:Rule(order = 0)
    var hiltAndroidRule = HiltAndroidRule(this)

    @Before
    fun setUp(){
        hiltAndroidRule.inject()
    }

    @Test
    fun testThatOnClickFundWalletButtonNavigateToFundWalletFragment(){
        val navController = mock(NavController::class.java)
        launchFragmentInHiltContainer<HomeFragment>{
            Navigation.setViewNavController(requireView(), navController)
        }
        onView(withId(R.id.btn_fund_wallet)).perform(click())
        verify(navController).navigate(HomeFragmentDirections.actionHomeFragmentToFundWalletFragment())
    }

    @Test
    fun testThatOnClickStartYourJourneyNavigateToSelectSpaceCraftFragment(){
        val navController = mock(NavController::class.java)
        launchFragmentInHiltContainer<HomeFragment> {
           Navigation.setViewNavController(requireView(), navController)
        }
        onView(withId(R.id.lyt_start_journey)).perform(click())
        verify(navController).navigate(HomeFragmentDirections.actionHomeFragmentToSelectSpaceCraftFragment())
    }

}

