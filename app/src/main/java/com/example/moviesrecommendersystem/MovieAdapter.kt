package com.example.moviesrecommendersystem

import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import java.net.URL


//class MovieListAdapter(private val context : Context, private val responseList : ArrayList<Movie>) : BaseAdapter() {
//    override fun getCount(): Int {
//        return responseList.size
//    }
//
//    override fun getItem(p0: Int): Any {
//        return responseList[p0]
//    }
//
//    override fun getItemId(p0: Int): Long {
//        return responseList[p0].id.toLong()
//    }
//
//    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
//        val view = p1?: LayoutInflater.from(p2?.context).inflate(R.layout.sublist_movie, p2, false)
//        val title = view.findViewById<TextView>(R.id.movieTitle)
//        title.text = responseList[p0].original_title
//
////        val overview = view.findViewById<TextView>(R.id.movieDescription)
////        overview.text = responseList[p0].overview
//
//        var rating = view.findViewById<TextView>(R.id.rating)
//        var rate = Math.round(responseList[p0].vote_average * 10.0) / 10.0
//        rating.text = rate.toString()
//
//        var posterUrl = "https://image.tmdb.org/t/p/w500${responseList[p0].poster_path}"
//        val poster = view.findViewById<ImageView>(R.id.posterImage)
//        Glide.with(context)
//            .load(posterUrl)
//            .into(poster);
//
//        return view
//    }
//
//}

class MovieListAdapter(private val movieList : ArrayList<Movie>) : RecyclerView.Adapter<MovieListAdapter.MyViewHolder>(){

    private var onClickListener: OnClickListener? = null

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val title = itemView.findViewById<TextView>(R.id.movieTitle)
        val poster = itemView.findViewById<ImageView>(R.id.posterImage)
        val rating = itemView.findViewById<TextView>(R.id.rating)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.sublist_movie, parent, false)

        return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val movie = movieList[position]

        holder.title.text = movie.original_title

        val rate = Math.round(movie.vote_average * 10.0)/10.0
        holder.rating.text = rate.toString()

        var posterUrl = "https://image.tmdb.org/t/p/w500${movieList[position].poster_path}"

        Picasso.get()
            .load(posterUrl)
            .into(holder.poster);

        holder.itemView.setOnClickListener {
            onClickListener?.onClick(position, movie)
        }
    }

    fun setOnClickListener(listener: OnClickListener?) {
        this.onClickListener = listener
    }


    interface OnClickListener {
        fun onClick(position: Int, model: Movie)
    }

}