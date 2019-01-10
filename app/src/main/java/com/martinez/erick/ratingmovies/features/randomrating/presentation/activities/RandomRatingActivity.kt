package com.martinez.erick.ratingmovies.features.randomrating.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.martinez.erick.ratingmovies.R
import com.martinez.erick.ratingmovies.RatingMoviesApp
import com.martinez.erick.ratingmovies.core.di.MovieModule
import com.martinez.erick.ratingmovies.features.randomrating.presentation.fragments.MovieListFragment
import dagger.android.support.DaggerAppCompatActivity


class RandomRatingActivity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_rating)

        val movieComponent = (application as RatingMoviesApp)
            .getAppComponent()
            .randomRatingActivityComponent(MovieModule())
            .injectRandomRatingActivity(this)

        initViews()
    }

    private fun initViews() {
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().add(R.id.fragment_container, MovieListFragment()).commit()
    }

}
