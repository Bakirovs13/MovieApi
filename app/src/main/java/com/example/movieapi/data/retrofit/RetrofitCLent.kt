package com.example.movieapi.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitCLent {

    private var retrofit :Retrofit? = null

    fun getCLient(baseUrl:String?) :Retrofit{
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
        return retrofit!!
    }

}