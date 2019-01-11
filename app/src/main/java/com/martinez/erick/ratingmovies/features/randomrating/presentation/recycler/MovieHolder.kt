package com.martinez.erick.ratingmovies.features.randomrating.presentation.recycler

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.martinez.erick.ratingmovies.core.glide.GlideApp
import com.martinez.erick.ratingmovies.core.sqlite.MovieEntity
import kotlinx.android.synthetic.main.row_movies.view.*

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

class MovieHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val zeroLong = 0L
    private val zeroFloat = 0f

    private val image: ImageView = itemView.img_movie
    private val name: TextView = itemView.tv_movie_name
    private val rateBar: RatingBar = itemView.rb_movie
    private val rating: TextView = itemView.tv_average_rating

    internal fun bind(movie: MovieEntity, listener: (movie: MovieEntity, rating: Float) -> Unit){

        name.text = movie.name
        val avgRating: Float = if(movie.votes == zeroLong) zeroFloat else movie.totalRating/movie.votes
        rating.text = avgRating.toString()
        getImage(movie.image, image)
        rateBar.setOnRatingBarChangeListener { _, rating, _ ->
            listener(movie, rating)
        }
    }

    private fun getImage(@DrawableRes image: Int, imageView: ImageView) {
        GlideApp.with(imageView.context).load(image).into(imageView)
    }

}