package com.martinez.erick.ratingmovies.core.sqlite

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers

/*
 Created by Erick Martínez Armendáriz on 1/8/2019
*/

private const val dbName = "movies"

/*
var roomDb purpose is to have reference for the insertion of the preData
 */
class RoomProvider (private val application: Context) {

    private var roomDb: RoomDB? = null

    internal fun createDB(): RoomDB {

        return roomDb ?: Room.databaseBuilder(application, RoomDB::class.java, dbName)
                .addCallback(object : RoomDatabase.Callback() {

                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Completable
                                .fromAction { roomDb?.movieDao()?.insert(preData) }
                                .subscribeOn(Schedulers.io())
                                .subscribe()
                    }
                })
                .build().also { roomDb = it }
    }

    val preData = listOf(
            MovieEntity(0, "0", 0f, 0, "URL0"),
            MovieEntity(1, "1", 0f, 0, "URL1"),
            MovieEntity(2, "2", 0f, 0, "URL2"),
            MovieEntity(3, "3", 0f, 0, "URL3"),
            MovieEntity(4, "4", 0f, 0, "URL4"),
            MovieEntity(5, "5", 0f, 0, "URL5"),
            MovieEntity(6, "6", 0f, 0, "URL6"),
            MovieEntity(7, "7", 0f, 0, "URL7"),
            MovieEntity(8, "8", 0f, 0, "URL8"),
            MovieEntity(9, "9", 0f, 0, "URL9"))

}