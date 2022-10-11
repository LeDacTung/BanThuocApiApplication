package com.example.banthuocapiapplication.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : BaseActivity> : Fragment(),  BaseView {

    lateinit var mRootView : View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mRootView = inflater.inflate(getLayoutId(), container, false)

        onPrepareLayout()

        return  mRootView
    }

    fun getRootView() : View {
        return mRootView
    }

    protected fun getBaseActivity() : T {
        return activity as T
    }

    abstract fun getLayoutId() : Int

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

    override fun getViewContext(): BaseActivity {
        return activity as BaseActivity
    }

    override fun showProgress() {
        Log.d("showProgress", "showProgress")
    }



}