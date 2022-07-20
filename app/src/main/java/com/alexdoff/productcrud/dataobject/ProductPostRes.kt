package com.alexdoff.productcrud.dataobject

data class ProductPostRes(
    val created_at: String,
    val description: String,
    val id: Int,
    val name: String,
    val price: Int,
    val updated_at: String
)