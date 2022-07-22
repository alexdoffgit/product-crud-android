package com.alexdoff.productcrud.productlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alexdoff.productcrud.repository.ProductRepo

class ProductItemViewModelFactory(private val repo: ProductRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductItemViewModel(repo) as T
    }
}