package com.example.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.moviecatalogue.R
import com.example.moviecatalogue.utils.DataDummy
import org.hamcrest.CoreMatchers
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    private val dummyMovie = DataDummy.generateDataMovies()
    private val dummyShow = DataDummy.generateDataShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadMovies() {
        Espresso.onView(ViewMatchers.withId(R.id.rv_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        Espresso.onView(ViewMatchers.withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))
        Espresso.onView(ViewMatchers.withId(R.id.tv_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_title))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyMovie[0].title)))
        Espresso.onView(ViewMatchers.withId(R.id.tv_status))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_status))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyMovie[0].status)))
        Espresso.onView(ViewMatchers.withId(R.id.tv_language))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_language))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyMovie[0].originalLanguage)))
        Espresso.onView(ViewMatchers.withId(R.id.tv_description))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_description))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyMovie[0].description)))
        Espresso.onView(ViewMatchers.withId(R.id.list_casts))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onData(CoreMatchers.anything()).inAdapterView(ViewMatchers.withId(R.id.list_casts)).atPosition(0).
        onChildView(ViewMatchers.withId(R.id.tv_castName)).
        check(ViewAssertions.matches(ViewMatchers.withText(dummyMovie[0].casts[0])))
    }

    @Test
    fun loadShows() {
        Espresso.onView(ViewMatchers.withText("TV SHOWS")).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.rv_show))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rv_show))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyShow.size))
    }

    @Test
    fun loadDetailShow() {
        Espresso.onView(ViewMatchers.withText("TV SHOWS")).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.rv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))
        Espresso.onView(ViewMatchers.withId(R.id.tv_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_title))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyShow[0].title)))
        Espresso.onView(ViewMatchers.withId(R.id.tv_status))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_status))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyShow[0].status)))
        Espresso.onView(ViewMatchers.withId(R.id.tv_language))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_language))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyShow[0].originalLanguage)))
        Espresso.onView(ViewMatchers.withId(R.id.tv_description))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_description))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyShow[0].description)))
        Espresso.onView(ViewMatchers.withId(R.id.list_casts))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onData(CoreMatchers.anything()).inAdapterView(ViewMatchers.withId(R.id.list_casts)).atPosition(0).
        onChildView(ViewMatchers.withId(R.id.tv_castName)).
        check(ViewAssertions.matches(ViewMatchers.withText(dummyShow[0].casts[0])))
    }

}