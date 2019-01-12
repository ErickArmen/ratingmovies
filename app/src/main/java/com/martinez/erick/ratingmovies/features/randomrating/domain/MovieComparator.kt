package com.martinez.erick.ratingmovies.features.randomrating.domain

import com.martinez.erick.ratingmovies.core.sqlite.MovieEntity

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

/**
 * Comparator for movies
 */
class MovieComparator: Comparator<MovieEntity> {

    override fun compare(o1: MovieEntity?, o2: MovieEntity?): Int {
        if (o1 != null && o2 != null){

            if (o1.votes == 0L && o2.votes != 0L){
                return 1
            }else if(o1.votes != 0L && o2.votes == 0L){
                return -1
            }

            return if ((o1.votes == 0L && o2.votes == 0L) || (o1.totalRating/o1.votes == o2.totalRating/o2.votes)){
                0
            }else{
                when(o1.totalRating/o1.votes > o2.totalRating/o2.votes){
                    true -> -1
                    false -> 1
                }
            }
        }else{
            return 0
        }
    }
}