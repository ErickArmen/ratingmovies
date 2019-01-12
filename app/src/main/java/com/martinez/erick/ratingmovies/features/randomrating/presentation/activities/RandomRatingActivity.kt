package com.martinez.erick.ratingmovies.features.randomrating.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.martinez.erick.ratingmovies.R
import com.martinez.erick.ratingmovies.RatingMoviesApp
import com.martinez.erick.ratingmovies.core.di.MovieModule
import com.martinez.erick.ratingmovies.features.randomrating.presentation.fragments.MovieListFragment


class RandomRatingActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_rating)

        if (savedInstanceState == null){
            (application as RatingMoviesApp)
                .getAppComponent()
                .randomRatingActivityComponent(MovieModule())
                .injectRandomRatingActivity(this)

                initViews()
        }
    }

    private fun initViews() {
        fragmentManager.beginTransaction().add(R.id.fragment_container, MovieListFragment()).commit()
    }

}
