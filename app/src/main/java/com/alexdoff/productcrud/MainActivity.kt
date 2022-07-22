package com.alexdoff.productcrud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.alexdoff.productcrud.databinding.ActivityMainBinding
import com.alexdoff.productcrud.productlist.ProductItemViewModel
import com.alexdoff.productcrud.productlist.ProductItemViewModelFactory
import com.alexdoff.productcrud.repository.ProductRepo

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private val client = RetrofitInstance.api
    private lateinit var productItemViewModel: ProductItemViewModel
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        navController = findNavController(R.id.nav_host_fragment)
//
//        setupActionBarWithNavController(navController)

        val productRepo = ProductRepo(client)
        val productItemViewModelFactory = ProductItemViewModelFactory(productRepo)
        productItemViewModel = ViewModelProvider(
            this, productItemViewModelFactory)[ProductItemViewModel::class.java]
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return super.onSupportNavigateUp() || navController.navigateUp()
//    }
}