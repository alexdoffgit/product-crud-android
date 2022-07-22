package com.alexdoff.productcrud

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val baseUrl = "https://procrud.my.id/api/"

    private fun interceptor(): HttpLoggingInterceptor {
        val i = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            i.setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            i.setLevel(HttpLoggingInterceptor.Level.NONE)
        }

        return i
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor())
        .build()

    val api: ProductApiInterface by lazy {
        Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApiInterface::class.java)
    }
}