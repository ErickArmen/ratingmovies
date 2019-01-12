package com.martinez.erick.ratingmovies.core.di

import android.app.Application
import com.martinez.erick.ratingmovies.RatingMoviesApp
import com.martinez.erick.ratingmovies.core.sqlite.MovieEntity
import com.martinez.erick.ratingmovies.core.sqlite.RoomDB
import com.martinez.erick.ratingmovies.features.randomrating.data.LocalMovies
import com.martinez.erick.ratingmovies.features.randomrating.domain.Reader
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import io.reactivex.Observable
import javax.inject.Singleton

/*
 Created by Erick Martínez Armendáriz on 1/8/2019
*/


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun injectReader(reader: Reader<Observable<MutableList<MovieEntity>>>): Reader<Observable<MutableList<MovieEntity>>>

    fun randomRatingActivityComponent(movieModule: MovieModule): MovieComponent
}