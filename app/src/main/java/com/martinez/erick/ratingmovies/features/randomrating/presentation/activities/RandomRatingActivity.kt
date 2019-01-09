package com.martinez.erick.ratingmovies.features.randomrating.presentation.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.martinez.erick.ratingmovies.R
import com.martinez.erick.ratingmovies.core.sqlite.RoomDB
import dagger.android.AndroidInjection
import dagger.android.DaggerActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RandomRatingActivity : DaggerActivity() {

    @Inject
    lateinit var viewModel: ViewModelProvider.Factory
    @Inject
    lateinit var db: RoomDB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_rating)


        db.movieDao().getMovies().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
            Log.i("Testing", it[0].name)
        },
                        {
                            Log.i("Testing Error", it.message)
                        })

    }
}
