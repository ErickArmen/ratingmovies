package com.martinez.erick.ratingmovies.core.extensions

import androidx.lifecycle.LifecycleOwner
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

fun <T: Any, O: Observable<T>> LifecycleOwner.observe(disposable: CompositeDisposable,
                                                        observable: O, onNext: (T) -> Unit,
                                                        onError: (t: Throwable) -> Unit = {}) =
    disposable.add(observable.subscribe(
        {
            onNext(it)
        },
        {
            onError(it)
        }
    ))

fun <C :Completable> LifecycleOwner.observe(disposable: CompositeDisposable,
                                                        completable: C, onComplete: () -> Unit,
                                                        onError: (t: Throwable) -> Unit = {}) =
    disposable.add(completable.subscribe(
        {
            onComplete()
        },
        {
            onError(it)
        }
    ))