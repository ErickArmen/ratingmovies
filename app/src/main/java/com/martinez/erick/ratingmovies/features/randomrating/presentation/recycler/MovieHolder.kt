package com.martinez.erick.ratingmovies.features.randomrating.presentation.recycler

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.martinez.erick.ratingmovies.core.sqlite.MovieEntity
import kotlinx.android.synthetic.main.row_movies.view.*

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

//todo test different kind of images width height
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
        //image.setImageDrawable(getImage(movie.imageUrl))
        rateBar.setOnRatingBarChangeListener { _, rating, _ ->
            listener(movie, rating)
        }
    }

    private fun getImage(url: String): Drawable {
        TODO("Add Picasso")
    }

}