package com.example.banthuocapiapplication.screen.splash

import android.widget.TextView
import androidx.core.view.doOnAttach
import androidx.viewpager2.widget.ViewPager2
import com.example.banthuocapiapplication.R
import com.example.banthuocapiapplication.adapter.SplashAdapter
import com.example.banthuocapiapplication.base.BaseActivity
import com.example.banthuocapiapplication.base.BaseView
import com.example.banthuocapiapplication.model.Splash
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class SplashActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    lateinit var mViewPager2: ViewPager2
    lateinit var mSplashs : ArrayList<Splash>
    lateinit var mSplashAdapter: SplashAdapter
    lateinit var mDots : WormDotsIndicator


    override fun onPrepareLayout() {
        super.onPrepareLayout()
        init()
    }

    private fun init(){
        mViewPager2 = findViewById(R.id.viewPager)
        mDots = findViewById(R.id.worm_dots_indicator)

        mSplashs = ArrayList()
        addValueList()

        mSplashAdapter = SplashAdapter(mSplashs, mViewPager2)

        mViewPager2.adapter = mSplashAdapter
        mDots.attachTo(mViewPager2)

    }

    private fun addValueList(){
        val splash1 = Splash(R.drawable.img_splash_1, getViewContext().getString(R.string.title_splash_1), getString(R.string.sub_title_splash_1))
        val splash2 = Splash(R.drawable.img_splash_1, getViewContext().getString(R.string.title_splash_2), getString(R.string.sub_title_splash_2))
        val splash3 = Splash(R.drawable.img_splash_1, getViewContext().getString(R.string.title_splash_3), getString(R.string.sub_title_splash_3))

        mSplashs.add(splash1)
        mSplashs.add(splash2)
        mSplashs.add(splash3)

    }
}