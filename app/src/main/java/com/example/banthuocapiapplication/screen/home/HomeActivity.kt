package com.example.banthuocapiapplication.screen.home

import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.banthuocapiapplication.R
import com.example.banthuocapiapplication.base.BaseActivity
import com.example.banthuocapiapplication.factory.ProductViewModelProviderFactory
import com.example.banthuocapiapplication.repository.ProductRepository
import com.example.banthuocapiapplication.screen.home.v2.CategoryTabFragment
import com.example.banthuocapiapplication.screen.home.v2.HomeTabFragment
import com.example.banthuocapiapplication.screen.home.v2.PersonTabFragment
import com.example.banthuocapiapplication.screen.home.v2.SettingTabFragment
import com.example.banthuocapiapplication.viewmodel.ProductViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    lateinit var mFrameLayout: FrameLayout
    lateinit var mBottomNavigationView : BottomNavigationView

    lateinit var productViewModel: ProductViewModel

    override fun onPrepareLayout() {
        super.onPrepareLayout()
        initViewModel()

        mFrameLayout = findViewById(R.id.frameLayout)
        addFragmentToActivity(HomeTabFragment(productViewModel))

        mBottomNavigationView = findViewById(R.id.bottomNavigationView)
        mBottomNavigationView.background = null
        mBottomNavigationView.menu.getItem(2).isEnabled = false

        mBottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home_menu -> addFragmentToActivity(HomeTabFragment(productViewModel))
                R.id.category_menu -> addFragmentToActivity(CategoryTabFragment())
                R.id.person_menu -> addFragmentToActivity(PersonTabFragment())
                R.id.setting_menu -> addFragmentToActivity(SettingTabFragment())
            }
            true
        }
    }

    fun initViewModel() {
        val productRepository = ProductRepository()
        val viewModelProvider = ProductViewModelProviderFactory(application, productRepository)
        productViewModel = ViewModelProvider(this, viewModelProvider)[ProductViewModel::class.java]
    }

    private fun addFragmentToActivity(fragment: Fragment?){
        if (fragment == null) return
        val fm = supportFragmentManager
        val tr = fm.beginTransaction()
        tr.replace(R.id.frameLayout, fragment)
        tr.commit()
    }

}

