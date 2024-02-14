package com.mokshith.gittest.retrofit

import com.mokshith.gittest.modelClasses.MealsCategoriesResponse
import retrofit2.Response
import retrofit2.http.GET

interface WebServices {

    @GET("categories.php")
    suspend fun getMealsData(): Response<MealsCategoriesResponse>


//    @GET("/todos")
//    suspend fun getTodosList(): Response<List<RetrofitCourseModel>>


}