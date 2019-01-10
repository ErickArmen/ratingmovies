package com.martinez.erick.ratingmovies.core.extensions

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

fun <T> Observable<T>.subscribeAndObserve(): Observable<T> =
    this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun Completable.subscribeAndObserve(): Completable =
        this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())