package com.martinez.erick.ratingmovies.core.di


import android.app.Application
import com.martinez.erick.ratingmovies.core.di.viewmodel.ViewModelModule
import com.martinez.erick.ratingmovies.core.sqlite.MovieEntity
import com.martinez.erick.ratingmovies.core.sqlite.RoomDB
import com.martinez.erick.ratingmovies.core.sqlite.RoomProvider
import com.martinez.erick.ratingmovies.features.randomrating.data.LocalMovies
import com.martinez.erick.ratingmovies.features.randomrating.data.MovieRepository
import com.martinez.erick.ratingmovies.features.randomrating.domain.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import javax.inject.Named
import javax.inject.Singleton

/*
 Created by Erick Martínez Armendáriz on 1/8/2019
*/


@Module
class AppModule(private val application: Application) {

    @Singleton
    @Provides
    fun injectRoom(): RoomDB = RoomProvider(application).createDB()

   /*@Provides
    @Named(movieReaderName)
    fun injectMovieReader(localMovies: LocalMovies): Reader<Observable<MutableList<MovieEntity>>>{
        return MovieReader(localMovies)
    }

    @Provides
    @Named(movieUpdaterName)
    fun injectMovieUpdater(localMovies: LocalMovies): Updater<MovieEntity>{
        return MovieUpdater(localMovies)
    }

    @Provides
    @Named(movieRaterName)
    fun injectMovieRater(): Rater<MovieEntity, Float> {
        return MovieRater()
    }*/

}