package com.alexdoff.productcrud

import com.alexdoff.productcrud.dataobject.Products
import retrofit2.Response

class ProductApiClient(
    private val p: ProductApiInterface
) {
    suspend fun getAllProducts(): Response<Products> {
        return p.getAllProduct()
    }
}