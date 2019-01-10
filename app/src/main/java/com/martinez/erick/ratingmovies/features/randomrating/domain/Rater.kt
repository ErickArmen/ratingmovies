package com.martinez.erick.ratingmovies.features.randomrating.domain

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

interface Rater<T, D> {
    fun rate(item: T, rating: D): T
}