package com.martinez.erick.ratingmovies.features.randomrating.presentation.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.martinez.erick.ratingmovies.R
import com.martinez.erick.ratingmovies.core.extensions.inflate
import com.martinez.erick.ratingmovies.core.sqlite.MovieEntity

/*
 Created by Erick Martínez Armendáriz on 1/9/2019
*/

class MovieAdapter(private val list: MutableList<MovieEntity>): RecyclerView.Adapter<MovieHolder>() {

    internal var listener: (movie: MovieEntity, rating: Float) -> Unit = {_, _ ->}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder =
        MovieHolder(parent.inflate(R.layout.row_movies))

    override fun getItemCount(): Int = list.size

    internal fun updateList(newList: MutableList<MovieEntity>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) =
        holder.bind(list[position], listener)
}