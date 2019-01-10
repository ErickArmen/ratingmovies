package com.martinez.erick.ratingmovies.features.randomrating.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.martinez.erick.ratingmovies.R
import com.martinez.erick.ratingmovies.RatingMoviesApp
import com.martinez.erick.ratingmovies.core.di.MovieModule
import com.martinez.erick.ratingmovies.core.extensions.observe
import com.martinez.erick.ratingmovies.core.extensions.toast
import com.martinez.erick.ratingmovies.core.extensions.viewModel
import com.martinez.erick.ratingmovies.core.sqlite.MovieEntity
import com.martinez.erick.ratingmovies.features.randomrating.domain.MovieComparator
import com.martinez.erick.ratingmovies.features.randomrating.presentation.recycler.MovieAdapter
import com.martinez.erick.ratingmovies.features.randomrating.presentation.viewmodels.RandomRatingViewModel
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_movie_list.*
import java.util.*
import javax.inject.Inject

/*
 Created by Erick Martínez Armendáriz on 1/8/2019
*/

class MovieListFragment: Fragment() {

    @Inject lateinit var vmFactory: ViewModelProvider.Factory
    private val compositeDisposable = CompositeDisposable()
    private lateinit var randomRatingViewModel: RandomRatingViewModel
    private var movieList = mutableListOf<MovieEntity>()
    private lateinit var mainAdapter: MovieAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_movie_list, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val movieComponent = (activity?.application as RatingMoviesApp)
            .getAppComponent()
            .randomRatingActivityComponent(MovieModule())
            .injectMovieFragment(this)

        initViews()
        randomRatingViewModel = viewModel(vmFactory){
            observe(compositeDisposable, getAllMovies(), onNext = ::setRecyclerList, onError = ::showError)
        }
    }

    private fun initViews(){
        rv_movies.apply {
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        }

        mainAdapter = MovieAdapter(movieList)
        mainAdapter.listener = {movie, rating -> updateRating(movie, rating) }
        rv_movies.adapter = mainAdapter
    }

    private fun setRecyclerList(list: MutableList<MovieEntity>){
        movieList = list
        Collections.sort(movieList, MovieComparator())
        mainAdapter.updateList(movieList)
    }

    private fun showError(t: Throwable){
        activity?.toast(t.message, Toast.LENGTH_LONG)
    }

    private fun updateRating(movieEntity: MovieEntity, rating: Float){
        observe(compositeDisposable, randomRatingViewModel.updateRating(movieEntity, rating),
            onComplete = ::successRating, onError = ::showError)
    }

    private fun successRating(){
        activity?.toast(getString(R.string.thank_you_for_rate), Toast.LENGTH_SHORT)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}