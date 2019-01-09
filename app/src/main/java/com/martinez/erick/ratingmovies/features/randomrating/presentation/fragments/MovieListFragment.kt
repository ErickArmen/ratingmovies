package com.martinez.erick.ratingmovies.features.randomrating.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.martinez.erick.ratingmovies.R
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_movie_list.*
import javax.inject.Inject

/*
 Created by Erick Martínez Armendáriz on 1/8/2019
*/
class MovieListFragment: DaggerFragment() {

    @Inject
    lateinit var viewModel: ViewModelProvider.Factory
    private val compositeDisposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_movie_list, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv_movies.apply {
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}