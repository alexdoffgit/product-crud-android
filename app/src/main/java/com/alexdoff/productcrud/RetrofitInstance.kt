package com.alexdoff.productcrud

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//import okhttp3.lo

object RetrofitInstance {
    private const val baseUrl = "https://procrud.my.id/api/"

//    private val interceptor: HttpLoggingInterceptor = HttpLoggingInte

    val api: ProductApiInterface by lazy {
        Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApiInterface::class.java)
    }
}