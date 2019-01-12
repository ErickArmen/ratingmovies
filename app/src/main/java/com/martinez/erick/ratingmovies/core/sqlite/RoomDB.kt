package com.martinez.erick.ratingmovies.core.sqlite

import androidx.room.Database
import androidx.room.RoomDatabase

/*
 Created by Erick Martínez Armendáriz on 1/8/2019
*/

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class RoomDB: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}