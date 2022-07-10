package com.example.movieapi.data.retrofit

import com.example.movieapi.data.model.Movie
import com.example.movieapi.data.model.SecondMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieApi {

    @GET("marvel")
    fun getMovieList(): Call<MutableList<Movie>>


    @GET("movie/top_rated")
     fun getTopRated(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?,
        @Query("region") region: String?
     ):Call<MutableList<SecondMovie>>

}