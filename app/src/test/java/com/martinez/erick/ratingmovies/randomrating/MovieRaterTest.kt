package com.martinez.erick.ratingmovies.randomrating

import com.martinez.erick.ratingmovies.core.sqlite.MovieEntity
import com.martinez.erick.ratingmovies.features.randomrating.domain.MovieRater
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

@RunWith(JUnit4::class)
class MovieRaterTest {

    private val movieRater = MovieRater()

    @Before
    fun setUp(){

    }

    @Test
    fun rateTest(){
        val movie = MovieEntity(0, "0", 5f, 1, 0)
        val rating = 4f
        val movieRated = movieRater.rate(movie, rating)
        Assert.assertEquals(4.5f, movieRated.totalRating/movieRated.votes)
    }

    @Test
    fun secondRateTest(){
        val movie = MovieEntity(0, "0", 4421321412f, 897263123, 0)
        val rating = 4f
        val movieRated = movieRater.rate(movie, rating)
        Assert.assertEquals(4.92f, movieRated.totalRating/movieRated.votes, 0.05f)
    }
}