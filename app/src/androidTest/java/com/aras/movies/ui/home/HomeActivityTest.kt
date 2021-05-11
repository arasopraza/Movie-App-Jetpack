//package com.aras.movies.ui.home
//
//import androidx.recyclerview.widget.RecyclerView
//import androidx.test.espresso.Espresso.onView
//import androidx.test.espresso.action.ViewActions.click
//import androidx.test.espresso.assertion.ViewAssertions.matches
//import androidx.test.espresso.contrib.RecyclerViewActions
//import androidx.test.espresso.matcher.ViewMatchers.*
//import androidx.test.ext.junit.rules.ActivityScenarioRule
//import com.aras.movies.R
//import com.aras.movies.utils.DataDummy
//import org.junit.Rule
//import org.junit.Test
//
//class HomeActivityTest {
//
//    private val dummyMovie = DataDummy.generateDummyMovies()
//    private val dummyTvshow = DataDummy.generateDummyTvshows()
//
//    @get:Rule
//    var activityRule = ActivityScenarioRule(HomeActivity::class.java)
//
//    @Test
//    fun loadMovies() {
//        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
//        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
//    }
//
//    @Test
//    fun loadDetailMovie() {
//        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
//        onView(withId(R.id.text_title_movie)).check(matches(isDisplayed()))
//        onView(withId(R.id.text_title_movie)).check(matches(withText(dummyMovie[0].title)))
//        onView(withId(R.id.text_release_movie)).check(matches(isDisplayed()))
//        onView(withId(R.id.text_release_movie)).check(matches(withText(dummyMovie[0].release)))
//        onView(withId(R.id.text_overview_movie)).check(matches(isDisplayed()))
//        onView(withId(R.id.text_overview_movie)).check(matches(withText(dummyMovie[0].description)))
//    }
//
//    @Test
//    fun loadTvshows() {
//        onView(withText("TV SHOW")).perform(click())
//        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
//        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvshow.size))
//    }
//
//    @Test
//    fun loadDetailTvshow() {
//        onView(withText("TV SHOW")).perform(click())
//        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
//        onView(withId(R.id.text_title_movie)).check(matches(isDisplayed()))
//        onView(withId(R.id.text_title_movie)).check(matches(withText(dummyTvshow[0].title)))
//        onView(withId(R.id.text_release_movie)).check(matches(isDisplayed()))
//        onView(withId(R.id.text_release_movie)).check(matches(withText(dummyTvshow[0].release)))
//        onView(withId(R.id.text_overview_movie)).check(matches(isDisplayed()))
//        onView(withId(R.id.text_overview_movie)).check(matches(withText(dummyTvshow[0].description)))
//    }
//}