package com.martinez.erick.ratingmovies.features.randomrating.domain

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

/**
 * Implement this interface if your class needs to read some repository.
 */
interface Reader <T> {
    fun read(id: String): T
}