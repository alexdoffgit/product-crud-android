package com.alexdoff.productcrud.repository

import com.alexdoff.productcrud.ProductApiInterface
import com.alexdoff.productcrud.dataobject.ProductBody

class ProductRepo(private val client: ProductApiInterface) {
    suspend fun getAllProducts() = client.getAllProduct()
    suspend fun createProduct(p: ProductBody) = client.createProduct(p)
    suspend fun updateProduct(id: String, p: ProductBody) = client.updateProduct(id, p)
    suspend fun deleteProduct(id: String) = client.deleteProduct(id)
}