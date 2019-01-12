package com.martinez.erick.ratingmovies

import android.app.Application
import com.martinez.erick.ratingmovies.core.di.AppComponent
import com.martinez.erick.ratingmovies.core.di.AppModule
import com.martinez.erick.ratingmovies.core.di.DaggerAppComponent

/*
 Created by Erick Martínez Armendáriz on 1/8/2019
*/


class RatingMoviesApp: Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    fun getAppComponent() = appComponent

}