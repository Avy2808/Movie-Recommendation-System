package com.example.moviesrecommendersystem

import java.net.URL


data class Movie(val id : Int, val original_title : String, val overview : String, val poster_path : String, val release_date : String, val runtime : Int, val vote_average : Float, val tagline : String)

//data class Movie(val id : Int, val title : String)

//data class MovieResults(val page: Int, results: )

data class MovieList(val page : Int, val results : ArrayList<Movie>)