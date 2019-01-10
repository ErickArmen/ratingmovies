package com.martinez.erick.ratingmovies

import android.app.Activity
import android.app.Application
import com.martinez.erick.ratingmovies.core.di.AppComponent
import com.martinez.erick.ratingmovies.core.di.AppModule
import com.martinez.erick.ratingmovies.core.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/*
 Created by Erick Martínez Armendáriz on 1/8/2019
*/


class RatingMoviesApp: Application()/*: DaggerApplication()*/ {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }


    /*override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent.builder().application(this).build()
        return appComponent
    }*/

    fun getAppComponent() = appComponent

}