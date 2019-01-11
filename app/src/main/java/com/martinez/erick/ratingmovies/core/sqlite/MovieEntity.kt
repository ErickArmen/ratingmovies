package com.martinez.erick.ratingmovies.core.sqlite

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
 Created by Erick Martínez Armendáriz on 1/8/2019
*/


@Entity
class MovieEntity(@PrimaryKey val uid: Int, var name: String, var totalRating: Float, var votes: Long, var image: Int)