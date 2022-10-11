package com.example.banthuocapiapplication.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.banthuocapiapplication.repository.ProductRepository
import com.example.banthuocapiapplication.viewmodel.ProductViewModel

class ProductViewModelProviderFactory (
    private val app : Application,
    private val productRepository: ProductRepository) : ViewModelProvider.Factory{

        override fun <T: ViewModel> create(modelClass: Class<T>): T {
            return ProductViewModel(app, productRepository) as T
        }

}