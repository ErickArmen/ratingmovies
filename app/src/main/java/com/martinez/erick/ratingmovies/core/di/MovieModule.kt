package com.martinez.erick.ratingmovies.core.di

import com.martinez.erick.ratingmovies.core.di.viewmodel.ViewModelModule
import com.martinez.erick.ratingmovies.core.sqlite.MovieEntity
import com.martinez.erick.ratingmovies.core.sqlite.RoomDB
import com.martinez.erick.ratingmovies.core.types.Rater
import com.martinez.erick.ratingmovies.core.types.Reader
import com.martinez.erick.ratingmovies.core.types.Updater
import com.martinez.erick.ratingmovies.features.randomrating.data.LocalMovies
import com.martinez.erick.ratingmovies.features.randomrating.data.MovieRepository
import com.martinez.erick.ratingmovies.features.randomrating.domain.*
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import javax.inject.Named

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

const val movieReaderName = "MovieReader"
const val movieUpdaterName = "MovieUpdater"
const val movieRaterName = "MovieRater"
const val movieRepositoryName = "MovieRepository"

@Module(includes = [ViewModelModule::class])
class MovieModule {


    @Provides
    @Named(movieRepositoryName)
    fun injectMovieRepository(roomDB: RoomDB): MovieRepository {
        return LocalMovies(roomDB)
    }


    @Provides
    @Named(movieReaderName)
    fun injectMovieReader(localMovies: LocalMovies): Reader<Observable<MutableList<MovieEntity>>> {
        return MovieReader(localMovies)
    }

    @MovieScope
    @Provides
    @Named(movieUpdaterName)
    fun injectMovieUpdater(localMovies: LocalMovies): Updater<MovieEntity> {
        return MovieUpdater(localMovies)
    }

    @MovieScope
    @Provides
    @Named(movieRaterName)
    fun injectMovieRater(): Rater<MovieEntity, Float> {
        return MovieRater()
    }
}