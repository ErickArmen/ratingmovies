package com.martinez.erick.ratingmovies.features.randomrating.data

import com.martinez.erick.ratingmovies.core.extensions.subscribeAndObserve
import com.martinez.erick.ratingmovies.core.sqlite.MovieEntity
import com.martinez.erick.ratingmovies.core.sqlite.RoomDB
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

class LocalMovies @Inject constructor(
    private val roomDB: RoomDB): MovieRepository {

    override fun getData(): Observable<MutableList<MovieEntity>> = roomDB.movieDao().getMovies().subscribeAndObserve()

    override fun setData(data: List<MovieEntity>) =
        Completable.fromAction { roomDB.movieDao().insert(data) }.subscribeAndObserve()

    override fun update(item: MovieEntity): Completable =
        Completable.fromAction { roomDB.movieDao().updateRating(item) }.subscribeAndObserve()


}