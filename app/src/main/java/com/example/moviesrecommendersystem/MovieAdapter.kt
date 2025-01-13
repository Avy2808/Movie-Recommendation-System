package com.example.moviesrecommendersystem

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class MovieListAdapter(private val context : Context, private val responseList : ArrayList<Movie>) : BaseAdapter() {
    override fun getCount(): Int {
        return responseList.size
    }

    override fun getItem(p0: Int): Any {
        return responseList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return responseList[p0].id.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = p1?: LayoutInflater.from(p2?.context).inflate(R.layout.sublist_movie, p2, false)
        val title = view.findViewById<TextView>(R.id.movieTitle)
        title.text = responseList[p0].original_title

//        val overview = view.findViewById<TextView>(R.id.movieDescription)
//        overview.text = responseList[p0].overview

        var rating = view.findViewById<TextView>(R.id.rating)
        var rate = Math.round(responseList[p0].vote_average * 10.0) / 10.0
        rating.text = rate.toString()

        var posterUrl = "https://image.tmdb.org/t/p/w500${responseList[p0].poster_path}"
        val poster = view.findViewById<ImageView>(R.id.posterImage)
        Glide.with(context)
            .load(posterUrl)
            .into(poster);

        return view
    }

}