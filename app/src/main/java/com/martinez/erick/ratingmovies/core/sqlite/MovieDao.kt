package com.martinez.erick.ratingmovies.core.sqlite

import androidx.room.*
import io.reactivex.Observable

/*
 Created by Erick Martínez Armendáriz on 1/8/2019
*/

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(list: List<MovieEntity>)

    @Query("SELECT * FROM MovieEntity")
    fun getMovies(): Observable<MutableList<MovieEntity>>

    @Update
    fun updateRating(movie: MovieEntity)
}