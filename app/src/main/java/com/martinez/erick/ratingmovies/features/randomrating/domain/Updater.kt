package com.martinez.erick.ratingmovies.features.randomrating.domain

import io.reactivex.Completable

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

interface Updater <T> {
    fun update(data: T): Completable
}