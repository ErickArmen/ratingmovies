package com.martinez.erick.ratingmovies.core.di

import android.app.Application
import com.martinez.erick.ratingmovies.RatingMoviesApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/*
 Created by Erick Martínez Armendáriz on 1/8/2019
*/


@Singleton
@Component(modules = [AndroidInjectionModule::class, AndroidSupportInjectionModule::class, AppModule::class,
    ActivitiesModule::class])
interface AppComponent: AndroidInjector<RatingMoviesApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    override fun inject(instance: RatingMoviesApp?)
}