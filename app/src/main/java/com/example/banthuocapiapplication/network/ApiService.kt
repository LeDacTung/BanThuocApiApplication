package com.example.banthuocapiapplication.network

import com.example.banthuocapiapplication.model.Product
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("sanpham_hot.php")
    fun getProductNews() : Observable<MutableList<Product>>

}