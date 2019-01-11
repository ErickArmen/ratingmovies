package com.martinez.erick.ratingmovies.features.randomrating.domain

import com.martinez.erick.ratingmovies.core.sqlite.MovieEntity
import javax.inject.Inject

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

/**
 * Use case to rate movies, you can implement all your logic related to rate MovieEntity.
 */
class MovieRater @Inject constructor(): Rater<MovieEntity, Float> {

    override fun rate(item: MovieEntity, rating: Float): MovieEntity {
        item.totalRating = item.totalRating + rating
        item.votes = item.votes + 1
        return item
    }


}