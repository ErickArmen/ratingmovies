package com.martinez.erick.ratingmovies.core.extensions

import android.content.Context
import android.widget.Toast

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

fun Context.toast(message: CharSequence?, duration: Int) = Toast.makeText(this, message, duration).show()