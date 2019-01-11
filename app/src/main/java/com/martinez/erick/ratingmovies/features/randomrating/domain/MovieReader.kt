package com.martinez.erick.ratingmovies.features.randomrating.domain


import com.martinez.erick.ratingmovies.core.di.movieRepositoryName
import com.martinez.erick.ratingmovies.core.sqlite.MovieEntity
import com.martinez.erick.ratingmovies.features.randomrating.data.LocalMovies
import com.martinez.erick.ratingmovies.features.randomrating.data.MovieRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

/**
 * Use case to read movies, you can implement all your logic related to read MovieEntity.
 */
class MovieReader @Inject constructor(
    @Named(movieRepositoryName)private val repository: MovieRepository): Reader<Observable<MutableList<MovieEntity>>>{

    override fun read(id: String): Observable<MutableList<MovieEntity>> =
        (repository as LocalMovies).getData()

}