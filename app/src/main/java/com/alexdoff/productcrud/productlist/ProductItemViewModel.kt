package com.alexdoff.productcrud.productlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexdoff.productcrud.dataobject.Products
import com.alexdoff.productcrud.repository.ProductRepo
import kotlinx.coroutines.*

class ProductItemViewModel(private val repo: ProductRepo): ViewModel() {
    val errorMessage = MutableLiveData<String>()
    val products = MutableLiveData<Products>()
    val loading = MutableLiveData<Boolean>()
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    fun getAllProduct() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val res = repo.getAllProducts()
            withContext(Dispatchers.Main) {
                if(res.isSuccessful) {
                    products.postValue(res.body())
                    loading.value = false
                } else {
                    onError("Error : ${res.message()} ")
                }
            }
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}