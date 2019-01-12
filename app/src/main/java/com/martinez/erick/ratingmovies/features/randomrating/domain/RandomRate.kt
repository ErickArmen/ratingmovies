package com.martinez.erick.ratingmovies.features.randomrating.domain

import java.util.concurrent.ThreadLocalRandom

/*
 Created by Erick Martínez Armendáriz on 1/10/2019
*/

/**
 * Object to generate random time, rating and position for any iterable object.
 */

class RandomRate {

    companion object {

        fun generateTime(): Long = ThreadLocalRandom.current().nextLong(0, 5)

        fun generateRatingPosition(upperBound: Int): RandomRatingPosition {
            val rating = ThreadLocalRandom.current().nextFloat() * 5
            val position = ThreadLocalRandom.current().nextInt(0, upperBound)
            return RandomRatingPosition(rating, position)
        }
    }
}