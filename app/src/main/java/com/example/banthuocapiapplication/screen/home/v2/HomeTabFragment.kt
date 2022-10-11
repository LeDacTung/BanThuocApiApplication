package com.example.banthuocapiapplication.screen.home.v2

import android.widget.Adapter
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.banthuocapiapplication.R
import com.example.banthuocapiapplication.adapter.BaseProductAdapter
import com.example.banthuocapiapplication.base.BaseFragment
import com.example.banthuocapiapplication.model.Product
import com.example.banthuocapiapplication.network.Resource
import com.example.banthuocapiapplication.screen.home.HomeActivity
import com.example.banthuocapiapplication.viewmodel.ProductViewModel
import org.w3c.dom.Text

class HomeTabFragment(
    val productViewModel: ProductViewModel
) : BaseFragment<HomeActivity>() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_tab_home
    }

    lateinit var mRecycleView: RecyclerView
    lateinit var mBaseProductAdapter: BaseProductAdapter
    lateinit var mProducts : MutableList<Product>

    override fun onPrepareLayout() {
        super.onPrepareLayout()

        initRecycleView()
        loadData()
    }

    private fun initRecycleView(){
        mRecycleView = getRootView().findViewById(R.id.recycleView)

        val layoutManager = LinearLayoutManager(getBaseActivity(), LinearLayoutManager.HORIZONTAL, false)
        mRecycleView.layoutManager = layoutManager

        mProducts = ArrayList()

        mBaseProductAdapter = BaseProductAdapter(getBaseActivity())
        mRecycleView.adapter = mBaseProductAdapter
    }

    private fun loadData() {
        productViewModel.getProductNew()

        productViewModel.getProductNewsLiveData().observe(this, Observer { response ->
            when(response){
                is Resource.Success -> {
                    response.data.let {
                            data -> onSuccess(data!!)
                    }
                }
                is Resource.Loading -> {
                    Toast.makeText(getBaseActivity(), "Load", Toast.LENGTH_LONG).show()
                }
                is Resource.Error -> {
                  response.message.let {
                      Toast.makeText(getBaseActivity(), "Error "+it.toString(), Toast.LENGTH_LONG).show()
                  }
                }
            }
        })
    }

    private fun onSuccess(products : MutableList<Product>){
        mProducts.clear()
        mProducts.addAll(products)
        mBaseProductAdapter.addProducts(mProducts)
    }
}