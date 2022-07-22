package com.alexdoff.productcrud

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alexdoff.productcrud.repository.ProductRepo
import java.lang.IllegalArgumentException

class ListProductViewModelFactory(private val repo: ProductRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(ListProductViewModel::class.java)) {
            ListProductViewModel(repo) as T
        } else {
            throw IllegalArgumentException("ViewModel not found")
        }
    }
}