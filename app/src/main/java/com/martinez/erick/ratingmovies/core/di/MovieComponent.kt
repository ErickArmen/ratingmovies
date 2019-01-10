package com.martinez.erick.ratingmovies.core.di

import com.martinez.erick.ratingmovies.core.sqlite.MovieEntity
import com.martinez.erick.ratingmovies.features.randomrating.domain.Reader
import com.martinez.erick.ratingmovies.features.randomrating.presentation.activities.RandomRatingActivity
import com.martinez.erick.ratingmovies.features.randomrating.presentation.fragments.MovieListFragment
import com.martinez.erick.ratingmovies.features.randomrating.presentation.viewmodels.RandomRatingViewModel
import dagger.Component
import dagger.Subcomponent
import dagger.android.support.AndroidSupportInjectionModule
import io.reactivex.Observable

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

/*
@MovieScope
@Subcomponent(modules = [AndroidSupportInjectionModule::class, ActivitiesModule::class, MovieModule::class, FragmentsModule::class])
interface MovieComponent {
    fun inject(randomRatingActivity: RandomRatingActivity)
}*/

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieComponent {
    fun injectRandomRatingActivity(randomRatingActivity: RandomRatingActivity)
    fun injectMovieFragment(movieListFragment: MovieListFragment)
}