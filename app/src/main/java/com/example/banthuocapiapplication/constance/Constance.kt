package com.example.banthuocapiapplication.constance

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel

class Constance {
    companion object{
        const val BASE_URL = "https://ledtandroid.000webhostapp.com/banthuoc/";

        @RequiresApi(Build.VERSION_CODES.M)
        public fun checkInternet(andVm: AndroidViewModel): Boolean{
            val connectivityManager= andVm.getApplication<Application>().getSystemService(
                Context.CONNECTIVITY_SERVICE
            ) as ConnectivityManager

            val activeNetwork= connectivityManager.activeNetwork?: return false
            val capabilities= connectivityManager.getNetworkCapabilities(activeNetwork)?: return false

            return when{
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)-> true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)-> true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)->true
                else -> false
            }
        }
    }
}