package com.martinez.erick.ratingmovies.core.types

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

/**
 * Implement this interface if your class needs to rate some object.
 */
interface Rater<T, D> {
    fun rate(item: T, rating: D): T
}