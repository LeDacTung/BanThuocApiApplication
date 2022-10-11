package com.example.banthuocapiapplication.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.banthuocapiapplication.constance.Constance
import com.example.banthuocapiapplication.model.Product
import com.example.banthuocapiapplication.network.Resource
import com.example.banthuocapiapplication.repository.ProductRepository
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Error
import java.lang.Exception

class ProductViewModel(
    private val app: Application,
    private val productRepository: ProductRepository
): AndroidViewModel(app) {
    private val compositeDisposable = CompositeDisposable()
    private val productNews : MutableLiveData<Resource<MutableList<Product>>> = MutableLiveData()
    private var products : MutableList<Product>? = null

    fun getProductNew()= viewModelScope.launch{
        callGetProductNew()
    }

    fun getProductNewsLiveData() : MutableLiveData<Resource<MutableList<Product>>>{
        return productNews
    }

    private fun callGetProductNew(){
//        productNews.postValue(Resource.Loading())
//        try {
//
//        }catch (e: Exception){
//            Log.d("call product new exception : ", e.message!!)
//        }

        val response = productRepository.getProductNews()
        handleResponse(response)
    }

    private fun handleResponse(response: Observable<MutableList<Product>>){
        compositeDisposable.add(
            response.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {result -> onSuccess(result) },
                    {error -> onError(error)}
                )
        )
    }

    private fun onSuccess(result: MutableList<Product>) {
        productNews.postValue(Resource.Success(products ?: result ))
    }

    private fun onError(error: Throwable) {
        productNews.postValue(Resource.Error(null, error.message))
    }

}