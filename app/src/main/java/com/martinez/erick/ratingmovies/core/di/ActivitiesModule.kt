package com.martinez.erick.ratingmovies.core.di

import com.martinez.erick.ratingmovies.features.randomrating.presentation.activities.RandomRatingActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/*
 Created by Erick Martínez Armendáriz on 1/8/2019
*/

@Module
interface ActivitiesModule {

    @ContributesAndroidInjector
    fun contributeRandomActivity(): RandomRatingActivity
}