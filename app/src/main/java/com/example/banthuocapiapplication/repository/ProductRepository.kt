package com.example.banthuocapiapplication.repository

import com.example.banthuocapiapplication.network.ServiceBuilder

class ProductRepository {

    private val serviceBuilder = ServiceBuilder()

    fun getProductNews() = serviceBuilder.getApiService().getProductNews()
}