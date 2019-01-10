package com.martinez.erick.ratingmovies.features.randomrating.data

import com.martinez.erick.ratingmovies.core.sqlite.MovieEntity
import io.reactivex.Completable
import io.reactivex.Observable

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

interface MovieRepository {
    fun getData(): Observable<MutableList<MovieEntity>> = Observable.empty()
    fun setData(data: List<MovieEntity>): Completable = Completable.complete()
    fun update(item: MovieEntity): Completable = Completable.complete()
    fun delete(item: MovieEntity): Completable = Completable.complete()
}