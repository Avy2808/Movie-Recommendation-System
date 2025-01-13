package com.example.moviesrecommendersystem

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("movie/now_playing?api_key=4dd9ef2b033b6f60c10e015f2fbea085")
//    fun getData() : Call<Movie>
    fun getData() : Call<MovieList>

}