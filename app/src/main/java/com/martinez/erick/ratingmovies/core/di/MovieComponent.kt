package com.martinez.erick.ratingmovies.core.di

import com.martinez.erick.ratingmovies.features.randomrating.presentation.activities.RandomRatingActivity
import com.martinez.erick.ratingmovies.features.randomrating.presentation.fragments.MovieListFragment
import dagger.Subcomponent

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieComponent {
    fun injectRandomRatingActivity(randomRatingActivity: RandomRatingActivity)
    fun injectMovieFragment(movieListFragment: MovieListFragment)
}