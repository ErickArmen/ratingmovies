package com.martinez.erick.ratingmovies.core.sqlite

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.martinez.erick.ratingmovies.R
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers

/*
 Created by Erick Martínez Armendáriz on 1/8/2019
*/

private const val dbName = "movies"

/**
 * Class to build RoomDatabase instance
 * @roomDb purpose is to have reference for the insertion of the preData
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

    //Ideally we put string url in place of a drawable to make more flexible if we need to add different images.
    //Also the apk become lighter.
    val preData = listOf(
            MovieEntity(0, "Avengers", 0f, 0, R.drawable.avengers),
            MovieEntity(1, "Avatar", 0f, 0, R.drawable.avatar),
            MovieEntity(2, "Batman", 0f, 0, R.drawable.batman),
            MovieEntity(3, "Harry Potter", 0f, 0, R.drawable.harry_potter),
            MovieEntity(4, "Hawkeye", 0f, 0, R.drawable.hawkeye),
            MovieEntity(5, "Hellcat", 0f, 0, R.drawable.hellcat),
            MovieEntity(6, "Ironman", 0f, 0, R.drawable.ironman),
            MovieEntity(7, "Predator", 0f, 0, R.drawable.predator),
            MovieEntity(8, "Spiderman", 0f, 0, R.drawable.spiderman),
            MovieEntity(9, "Venom", 0f, 0, R.drawable.venom))

}