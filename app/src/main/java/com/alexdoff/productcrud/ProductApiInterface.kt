package com.alexdoff.productcrud

import com.alexdoff.productcrud.dataobject.ProductBody
import com.alexdoff.productcrud.dataobject.ProductPostRes
import com.alexdoff.productcrud.dataobject.ProductUpdateRes
import com.alexdoff.productcrud.dataobject.Products
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ProductApiInterface {
    @GET("/product")
    suspend fun getAllProduct(): Response<Products>

    @POST("/product")
    suspend fun createProduct(@Body payload: ProductBody): Response<ProductPostRes>

    @PUT("/product/{id}")
    suspend fun updateProduct(@Path("id") id: String,
                      @Body payload: ProductBody): Response<ProductUpdateRes>

    @DELETE("/product/{id}")
    suspend fun deleteProduct(@Path("id") id: String): Response<String>
}