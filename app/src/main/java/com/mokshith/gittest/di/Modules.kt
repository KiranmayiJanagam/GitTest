package com.mokshith.gittest.di

import com.mokshith.gittest.common.ViewUtils.Companion.BASE_URL
import com.mokshith.gittest.common.ViewUtils.Companion.BASE_URL2
import com.mokshith.gittest.common.ViewUtils.Companion.baseOne
import com.mokshith.gittest.retrofit.WebServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Modules {
    @Provides
    @Singleton
    fun getRetrofitServiceInstance(retrofit: Retrofit): WebServices {
        return retrofit.create(WebServices::class.java)
    }

    @Provides
    @Singleton
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun getRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(
                BASE_URL
            )
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

  /*  @Provides
    @Singleton
    @Named("retrofit2")
    fun getRetrofitInstance2(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(
                BASE_URL
            )
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun getRetrofitServiceInstance2(@Named("retrofit2") retrofit: Retrofit): WebServices {
        return retrofit.create(WebServices::class.java)
    }
*/

}