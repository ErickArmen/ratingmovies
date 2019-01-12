package com.martinez.erick.ratingmovies.core.di

import com.martinez.erick.ratingmovies.core.sqlite.MovieEntity
import com.martinez.erick.ratingmovies.core.types.Reader
import dagger.Component
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