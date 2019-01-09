package com.martinez.erick.ratingmovies.core.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)
