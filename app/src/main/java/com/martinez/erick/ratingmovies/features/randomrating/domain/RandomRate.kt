package com.martinez.erick.ratingmovies.features.randomrating.domain

import android.os.Handler
import android.util.Log
import com.martinez.erick.ratingmovies.core.extensions.subscribeAndObserve
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function
import io.reactivex.functions.Function3
import java.util.*
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit

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