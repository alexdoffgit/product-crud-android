package com.alexdoff.productcrud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.alexdoff.productcrud.databinding.ActivityMainBinding
import com.alexdoff.productcrud.repository.ProductRepo

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setupActionBarWithNavController(findNavController(R.id.nav_host_fragment))
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val nc = findNavController(R.id.nav_host_fragment)
//        return  nc.navigateUp() || super.onSupportNavigateUp()
//    }
}