package com.example.movieapi.common

import com.example.movieapi.data.model.SecondMovie
import com.example.movieapi.data.retrofit.MovieApi
import com.example.movieapi.data.retrofit.RetrofitCLent

object Common {

    const val BASE_URL2 = "https://api.themoviedb.org/3/"
    private val BASE_URL = "https://www.simplifiedcoding.net/demos/"

    val retrofitService :MovieApi
    get() = RetrofitCLent.getCLient(BASE_URL).create(MovieApi::class.java)

    val retrofitService2 :MovieApi
        get() = RetrofitCLent.getCLient(BASE_URL2).create(MovieApi::class.java)

}