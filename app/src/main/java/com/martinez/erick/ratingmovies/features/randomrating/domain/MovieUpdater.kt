package com.martinez.erick.ratingmovies.features.randomrating.domain

import com.martinez.erick.ratingmovies.core.sqlite.MovieEntity
import com.martinez.erick.ratingmovies.features.randomrating.data.LocalMovies
import com.martinez.erick.ratingmovies.features.randomrating.data.MovieRepository
import io.reactivex.Completable
import javax.inject.Inject

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

class MovieUpdater @Inject constructor(
    private val movieRepository: MovieRepository): Updater<MovieEntity> {

    override fun update(data: MovieEntity): Completable {
        return (movieRepository as LocalMovies).update(data)
    }
}