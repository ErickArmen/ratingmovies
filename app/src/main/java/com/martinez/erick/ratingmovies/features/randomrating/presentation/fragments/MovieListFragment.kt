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
import com.martinez.erick.ratingmovies.features.randomrating.domain.RandomRate
import com.martinez.erick.ratingmovies.features.randomrating.domain.RandomRatingPosition
import com.martinez.erick.ratingmovies.features.randomrating.presentation.recycler.MovieAdapter
import com.martinez.erick.ratingmovies.features.randomrating.presentation.viewmodels.RandomRatingViewModel
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_movie_list.*
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/*
 Created by Erick Martínez Armendáriz on 1/8/2019
*/

class MovieListFragment: Fragment(), View.OnClickListener {

    @Inject lateinit var vmFactory: ViewModelProvider.Factory
    private val compositeDisposable = CompositeDisposable()
    private lateinit var randomRatingViewModel: RandomRatingViewModel
    private var movieList = mutableListOf<MovieEntity>()
    private lateinit var mainAdapter: MovieAdapter
    private val randomObservable: PublishSubject<RandomRatingPosition> = PublishSubject.create()
    private var randomFlag = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_movie_list, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity?.application as RatingMoviesApp)
            .getAppComponent()
            .randomRatingActivityComponent(MovieModule())
            .injectMovieFragment(this)

        initViews()
        randomRatingViewModel = viewModel(vmFactory){
            observe(compositeDisposable, getAllMovies(), onNext = ::setRecyclerList, onError = ::showError)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    private fun initViews(){
        rv_movies.apply {
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        }

        mainAdapter = MovieAdapter(movieList)
        mainAdapter.listener = {movie, rating -> updateRating(movie, rating) }
        rv_movies.adapter = mainAdapter
        btn_random.apply {
            setOnClickListener(this@MovieListFragment)
            val messageOnOff = if (randomFlag) getString(R.string.on) else getString(R.string.off)
            text = getString(R.string.random_rating, messageOnOff)
        }
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

        if (randomFlag){
            val randomRatePos = RandomRate.generateRatingPosition(movieList.size)
            val time = RandomRate.generateTime()
            compositeDisposable.add(Single.just(randomRatePos).delay(time, TimeUnit.SECONDS).subscribe { t ->
                randomObservable.onNext(t)
            })
        }

        activity?.toast(getString(R.string.thank_you_for_rate), Toast.LENGTH_SHORT)
    }

    private fun rateRandom() {

        randomFlag = !randomFlag
        val messageOnOff = if (randomFlag) getString(R.string.on) else getString(R.string.off)
        btn_random.text = (getString(R.string.random_rating, messageOnOff))

            compositeDisposable.add(randomObservable.subscribe {
                updateRating(movieList[it.pos], it.rating)
            })

        val randomRatePos = RandomRate.generateRatingPosition(movieList.size)
        updateRating(movieList[randomRatePos.pos], randomRatePos.rating)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_random -> {
                rateRandom()
            }
        }
    }

}