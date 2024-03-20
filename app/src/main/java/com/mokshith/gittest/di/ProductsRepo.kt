package com.mokshith.gittest.di

import com.mokshith.gittest.modelClasses.Product
import com.mokshith.gittest.retrofit.WebServices
import retrofit2.Response
import javax.inject.Inject

class ProductsRepo @Inject constructor(
    private val webServices: WebServices
) {

    //both getProducts() and getProductsList() does the same work
    suspend fun getProducts(): Response<List<Product>> {
        return webServices.getProducts()
    }

    suspend fun getProductsList() = webServices.getProducts()

    suspend fun getCategoriesList() = webServices.getCategories()


    suspend fun getProductsList1() = webServices.getProducts1()
}