package com.example.banthuocapiapplication.base

interface BaseView : BasePresenter {
    fun showProgress();

    fun hideProgress();

    fun onPrepareLayout();

    fun onRequestError(errorCode: String ,errorMessage: String);

    fun onRequestSuccess();

    override fun getViewContext() : BaseActivity

}