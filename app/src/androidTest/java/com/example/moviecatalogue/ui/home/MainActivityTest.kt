package com.example.moviecatalogue.ui.home

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.example.moviecatalogue.R
import com.example.moviecatalogue.utils.DataDummy
import com.example.moviecatalogue.utils.EspressoIdlingResource
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    private lateinit var instrumentalContext: Context

    private val dummyMovie = DataDummy.generateDataMovies()
    private val dummyShow = DataDummy.generateDataShows()
    private val dummyFavMovie = DataDummy.generateDummyFavMovie()
    private val dummyFavShow = DataDummy.generateDummyFavShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        instrumentalContext = InstrumentationRegistry.getInstrumentation().targetContext

        ActivityScenario.launch(MainActivity::class.java)

        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun loadMovies() {
        onView(ViewMatchers.withId(R.id.rv_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(ViewMatchers.withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))
        onView(ViewMatchers.withId(R.id.tv_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.tv_title))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyMovie[0].title)))
        onView(ViewMatchers.withId(R.id.tv_status))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.tv_status))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyMovie[0].status)))
        onView(ViewMatchers.withId(R.id.tv_language))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.tv_language))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyMovie[0].originalLanguage)))
        onView(ViewMatchers.withId(R.id.tv_description))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.tv_description))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyMovie[0].description)))
        onView(ViewMatchers.withId(R.id.list_casts))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onData(CoreMatchers.anything()).inAdapterView(ViewMatchers.withId(R.id.list_casts)).atPosition(0).
        onChildView(ViewMatchers.withId(R.id.tv_castName)).
        check(ViewAssertions.matches(ViewMatchers.withText(dummyMovie[0].casts[0])))
        onView(ViewMatchers.withId(R.id.iv_poster)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.iv_poster)).check(ViewAssertions.matches(ViewMatchers.withContentDescription(R.string.poster_film)))
    }

    @Test
    fun loadShows() {
        onView(ViewMatchers.withText("TV SHOWS")).perform(ViewActions.click())
        onView(ViewMatchers.withId(R.id.rv_show))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.rv_show))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyShow.size))
    }

    @Test
    fun loadDetailShow() {
        onView(ViewMatchers.withText("TV SHOWS")).perform(ViewActions.click())
        onView(ViewMatchers.withId(R.id.rv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))
        onView(ViewMatchers.withId(R.id.tv_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.tv_title))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyShow[0].title)))
        onView(ViewMatchers.withId(R.id.tv_status))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.tv_status))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyShow[0].status)))
        onView(ViewMatchers.withId(R.id.tv_language))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.tv_language))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyShow[0].originalLanguage)))
        onView(ViewMatchers.withId(R.id.tv_description))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.tv_description))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyShow[0].description)))
        onView(ViewMatchers.withId(R.id.list_casts))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onData(CoreMatchers.anything()).inAdapterView(ViewMatchers.withId(R.id.list_casts)).atPosition(0).
        onChildView(ViewMatchers.withId(R.id.tv_castName)).
        check(ViewAssertions.matches(ViewMatchers.withText(dummyShow[0].casts[0])))
        onView(ViewMatchers.withId(R.id.iv_poster)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.iv_poster)).check(ViewAssertions.matches(ViewMatchers.withContentDescription(R.string.poster_film)))
    }

    @Test
    fun loadFavMovies() {
        onView(ViewMatchers.withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))
        onView(ViewMatchers.withId(R.id.fab_favorite))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.fab_favorite))
            .perform(ViewActions.click())
        onView(ViewMatchers.withId(R.id.fab_favorite))
            .perform(ViewActions.pressBack())

        onView(ViewMatchers.withId(R.id.favorite))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.favorite))
            .perform(ViewActions.click())

        onView(ViewMatchers.withId(R.id.rv_fav_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.rv_fav_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyFavMovie.size))
    }

    @Test
    fun loadFavShows() {
        onView(ViewMatchers.withText("TV SHOWS")).perform(ViewActions.click())
        onView(ViewMatchers.withId(R.id.rv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))
        onView(ViewMatchers.withId(R.id.fab_favorite))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.fab_favorite))
            .perform(ViewActions.click())
        onView(ViewMatchers.withId(R.id.fab_favorite))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.pressBack())

        onView(ViewMatchers.withId(R.id.favorite))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.favorite))
            .perform(ViewActions.click())

        onView(ViewMatchers.withText("TV SHOWS")).perform(ViewActions.click())
        onView(ViewMatchers.withId(R.id.rv_fav_show))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.rv_fav_show))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyFavShow.size))
    }

}