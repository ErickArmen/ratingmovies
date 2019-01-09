package com.martinez.erick.ratingmovies.features.randomrating.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.martinez.erick.ratingmovies.R
import com.martinez.erick.ratingmovies.features.randomrating.presentation.fragments.MovieListFragment
import dagger.android.support.DaggerAppCompatActivity


class RandomRatingActivity : DaggerAppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_rating)

        initViews()
    }

    private fun initViews() {
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().add(R.id.fragment_container, MovieListFragment()).commit()
    }

}
