package com.example.moviesrecommendersystem

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.ScrollView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.moviesrecommendersystem.databinding.ActivityMainBinding
import com.example.moviesrecommendersystem.databinding.SublistMovieBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var movieList : ArrayList<Movie> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)


//        movieList.add(Movie(1, "Movie1"))
//        movieList.add(Movie(2, "Movie2"))
//        movieList.add(Movie(3, "Movie3"))
//        movieList.add(Movie(4, "Movie4"))
//        movieList.add(Movie(5, "Movie5"))
//        movieList.add(Movie(6, "Movie6"))

//        binding.movieButton.setOnClickListener{
//            getData()
//        }

        getData()

    }

    private fun getData(){
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please wait while the list is being loaded")
        progressDialog.show()

        RetrofitInstance.apiInterface.getData().enqueue(object : Callback<MovieList?> {
            override fun onResponse(call: Call<MovieList?>, response: Response<MovieList?>) {
                progressDialog.dismiss()

//                binding.movieTitle.text = response.body()?.original_title
//                binding.movieDescription.text = response.body()?.overview
//
//                var posterUrl = "https://image.tmdb.org/t/p/w500${response.body()?.poster_path}"
//                Glide.with(this@MainActivity).load(posterUrl).into(binding.posterImage);
                if (response.isSuccessful)movieList = response.body()?.results ?: arrayListOf()

                val listView = findViewById<GridView>(R.id.movieListView)
                listView.adapter = MovieListAdapter(this@MainActivity, movieList)

                listView.setOnItemClickListener(){ parent, view, position, id ->
                    val movie = parent.adapter.getItem(position) as Movie
//                    Toast.makeText(this@MainActivity, movie.original_title, Toast.LENGTH_SHORT).show()
//                    Toast.makeText(this@MainActivity, movie.overview, Toast.LENGTH_SHORT).show()
//                    Toast.makeText(this@MainActivity, movie.poster_path, Toast.LENGTH_SHORT).show()

//                    lateinit var binding2 : MovieListBinding
//                    binding2.movieTitle.text = movie.original_title
//                    binding2.movieDescription.text = movie.overview

                    intent = Intent(this@MainActivity, MoviesActivity::class.java)
                    intent.putExtra("title", movie.original_title)
                    intent.putExtra("overview", movie.overview)
                    intent.putExtra("posterpath", movie.poster_path)
                    intent.putExtra("releaseDate", movie.release_date)
                    intent.putExtra("runtime", movie.runtime.toString())

//                    if(movie.production_companies!=null)Toast.makeText(this@MainActivity, movie.production_companies.size, Toast.LENGTH_SHORT).show()

                    val solution = Math.round(movie.vote_average * 10.0) / 10.0
                    intent.putExtra("rating", solution.toString())
                    intent.putExtra("tagline", movie.tagline)

                    startActivity(intent)

                }

            }

            override fun onFailure(call: Call<MovieList?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.localizedMessage}", Toast.LENGTH_SHORT)
                    .show()
                progressDialog.dismiss()
            }
        })
    }

//    private fun getData(){
//        val listView = findViewById<ListView>(R.id.movieListView)
//        listView.adapter = MovieListAdapter(this, movieList)
//        listView.setOnItemClickListener(){ parent, view, position, id ->
//            val movie = parent.adapter.getItem(position) as Movie
//            Toast.makeText(this, movie.title, Toast.LENGTH_SHORT)
//        }
//    }

//    private fun getData() {
//
//        val progressDialog = ProgressDialog(this)
//        progressDialog.setMessage("Please wait while the data is being fetched")
//        progressDialog.show()
//
//        RetrofitInstance.apiInterface.getData().enqueue(object : Callback<Movie?> {
//            override fun onResponse(call: Call<Movie?>, response: Response<Movie?>) {
//                progressDialog.dismiss()
//                binding.movieTitle.text = response.body()?.original_title
//                binding.movieDescription.text = response.body()?.overview
//
//                var posterUrl = "https://image.tmdb.org/t/p/w500${response.body()?.poster_path}"
//                Glide.with(this@MainActivity).load(posterUrl).into(binding.posterImage);
//
//            }
//
//            override fun onFailure(call: Call<Movie?>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "${t.localizedMessage}", Toast.LENGTH_SHORT)
//                    .show()
//                progressDialog.dismiss()
//            }
//        })
//    }

//    private fun getData(){
//
//        val progressDialog = ProgressDialog(this)
//        progressDialog.setMessage("Please wait while the list is being loaded")
//        progressDialog.show()

//        RetrofitInstance.apiInterface.getData().enqueue(object : Callback<MovieList?> {
//            override fun onResponse(call: Call<MovieList?>, response: Response<MovieList?>) {
//                progressDialog.dismiss()
//
//                val movies = response.body()?.list
//                println(movies)
//                val listView = findViewById<ListView>(R.id.movieListView)
//                listView.adapter = MovieListAdapter(this@MainActivity, movies?: arrayListOf())
//            }
//
//            override fun onFailure(call: Call<MovieList?>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "${t.localizedMessage}", Toast.LENGTH_SHORT)
//                    .show()
//                progressDialog.dismiss()
//            }
//        })

//    }
}