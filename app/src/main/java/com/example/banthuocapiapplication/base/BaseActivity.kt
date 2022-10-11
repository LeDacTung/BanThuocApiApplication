package com.example.banthuocapiapplication.base

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), BaseView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        onPrepareLayout()
    }

    abstract fun getLayoutId() : Int

    override fun getViewContext(): BaseActivity {
        return this
    }

    override fun hideProgress() {
        Log.d("hideProgress", "hideProgress")
    }

    override fun onPrepareLayout() {
       Log.d("onPrepareLayout", "onPrepareLayout")
    }

    override fun onRequestError(errorCode: String, errorMessage: String) {
        Log.d("onRequestError", "onRequestError")
    }

    override fun onRequestSuccess() {
        Log.d("onRequestSuccess", "onRequestSuccess")
    }

    override fun showProgress() {
        Log.d("showProgress", "showProgress")
    }
}