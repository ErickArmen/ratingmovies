package com.martinez.erick.ratingmovies.core.types

import io.reactivex.Completable

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

/**
 * Implement this interface if your class needs to update some repository.
 */
interface Updater <T> {
    fun update(data: T): Completable
}