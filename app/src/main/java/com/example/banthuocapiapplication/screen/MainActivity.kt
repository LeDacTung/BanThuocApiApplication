package com.example.banthuocapiapplication.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.banthuocapiapplication.R
import com.example.banthuocapiapplication.factory.ProductViewModelProviderFactory
import com.example.banthuocapiapplication.network.Resource
import com.example.banthuocapiapplication.repository.ProductRepository
import com.example.banthuocapiapplication.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity() {

    lateinit var productViewModel: ProductViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txt = findViewById<TextView>(R.id.txt)
        val productRepository = ProductRepository()
        val viewModelProvider = ProductViewModelProviderFactory(application, productRepository)
        productViewModel = ViewModelProvider(this, viewModelProvider)[ProductViewModel::class.java]

        productViewModel.getProductNew()

        productViewModel.getProductNewsLiveData().observe(this, Observer { response ->
            when(response){
                is Resource.Success -> {
                    response.data.let { data ->
                        txt.text = "Thanh cong" + data!!.size
                    }
                }
                is Resource.Loading -> {
                    txt.text = "Load"
                }
                is Resource.Error -> {
                    txt.text = "Error"
                }
            }
        })
    }
}