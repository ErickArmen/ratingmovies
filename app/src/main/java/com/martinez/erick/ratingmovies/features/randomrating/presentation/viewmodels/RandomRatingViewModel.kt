package com.martinez.erick.ratingmovies.features.randomrating.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.martinez.erick.ratingmovies.core.di.movieRaterName
import com.martinez.erick.ratingmovies.core.di.movieReaderName
import com.martinez.erick.ratingmovies.core.di.movieUpdaterName
import com.martinez.erick.ratingmovies.core.sqlite.MovieEntity
import com.martinez.erick.ratingmovies.core.types.Rater
import com.martinez.erick.ratingmovies.core.types.Reader
import com.martinez.erick.ratingmovies.core.types.Updater
import com.martinez.erick.ratingmovies.features.randomrating.domain.*
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

/*
 Created by Erick Martínez Armendáriz on 1/8/2019
*/

class RandomRatingViewModel
@Inject constructor(
    @Named(movieReaderName) private val movieReader: Reader<Observable<MutableList<MovieEntity>>>,
    @Named(movieUpdaterName) private val movieUpdater: Updater<MovieEntity>,
    @Named(movieRaterName) private val movieRater: Rater<MovieEntity, Float>
): ViewModel() {

    fun getAllMovies(): Observable<MutableList<MovieEntity>> = (movieReader as MovieReader).read("None")

    fun updateRating(data: MovieEntity, rating: Float): Completable {
        return (movieUpdater as MovieUpdater).update((movieRater as MovieRater).rate(data, rating))
    }

}