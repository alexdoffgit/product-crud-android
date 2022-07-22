package com.alexdoff.productcrud

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexdoff.productcrud.dataobject.Products
import com.alexdoff.productcrud.repository.ProductRepo
import kotlinx.coroutines.*

class ListProductViewModel(private val repo: ProductRepo): ViewModel() {
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    val errorMessage = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()
    var products = MutableLiveData<Products>()

    fun getAllProduct() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val res = repo.getAllProducts()
            withContext(Dispatchers.Main) {
                if (res.isSuccessful) {
                    products.postValue(res.body())
                    loading.value = false
                } else {
                    onError("Error: ${res.message()}")
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