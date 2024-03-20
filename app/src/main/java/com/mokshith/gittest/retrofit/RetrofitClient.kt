package com.mokshith.gittest.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//const val BASE_URL = "https://dummyjson.com/"
//products list
//https://dummyjson.com/products

const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
//CategoriesList
//https://www.themealdb.com/api/json/v1/1/categories.php

class RetrofitClient {
    companion object {
        private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        private val clint: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val webServices: WebServices by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                //.client(clint)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WebServices::class.java)
        }
    }
}