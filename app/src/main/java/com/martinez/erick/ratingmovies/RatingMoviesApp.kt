package com.martinez.erick.ratingmovies

import android.app.Activity
import android.app.Application
import com.martinez.erick.ratingmovies.core.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/*
 Created by Erick Martínez Armendáriz on 1/8/2019
*/


class RatingMoviesApp: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
            DaggerAppComponent.builder().application(this).build()

}