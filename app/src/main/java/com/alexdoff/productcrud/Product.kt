package com.alexdoff.productcrud

data class Product(
    val created_at: String,
    val description: String,
    val name: String,
    val pid: String,
    val price: String,
    val updated_at: String
)