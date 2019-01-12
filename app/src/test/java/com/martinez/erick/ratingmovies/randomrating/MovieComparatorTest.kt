package com.martinez.erick.ratingmovies.randomrating

import com.martinez.erick.ratingmovies.core.sqlite.MovieEntity
import com.martinez.erick.ratingmovies.features.randomrating.domain.MovieComparator
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

@RunWith(JUnit4::class)
class MovieComparatorTest {

    private val movieComparator = MovieComparator()

    @Before
    fun setUp(){

    }

    @Test
    fun compareZeros(){
        val movie1 = MovieEntity(0, "0", 0f, 0, 0)
        val movie2 = MovieEntity(1, "0", 0f, 0, 1)
        Assert.assertEquals(0, movieComparator.compare(movie1, movie2))
    }

    @Test
    fun compareZeroWithOtherValue(){
        val movie1 = MovieEntity(0, "0", 5f, 1, 0)
        val movie2 = MovieEntity(1, "0", 0f, 0, 1)
        Assert.assertEquals(-1, movieComparator.compare(movie1, movie2))
    }

    @Test
    fun compareMovie1isGrater(){
        val movie1 = MovieEntity(0, "0", 5f, 1, 0)
        val movie2 = MovieEntity(1, "0", 4f, 1, 1)
        Assert.assertEquals(-1, movieComparator.compare(movie1, movie2))
    }

    @Test
    fun compareMovie2isGreater(){
        val movie1 = MovieEntity(0, "0", 4f, 1, 0)
        val movie2 = MovieEntity(1, "0", 5f, 1, 1)
        Assert.assertEquals(1, movieComparator.compare(movie1, movie2))
    }

    @Test
    fun compareEqualsNotZero(){
        val movie1 = MovieEntity(0, "0", 5f, 1, 0)
        val movie2 = MovieEntity(1, "0", 5f, 1, 1)
        Assert.assertEquals(0, movieComparator.compare(movie1, movie2))
    }


}