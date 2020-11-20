package com.flame.flames.ui.splashScreen

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.flame.flames.BR
import com.flame.flames.R
import com.flame.flames.databinding.ActivitySplashBinding
import com.flame.flames.ui.base.BaseActivity


class SplashScreen : BaseActivity<SplashScreenViewModel, ActivitySplashBinding>() {
    private lateinit var viewModel: SplashScreenViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        startWalkThrough()
    }

    private fun startWalkThrough() {
        viewModel.goToWalkThrough(this)
    }


    override fun getViewModel(): SplashScreenViewModel {
        viewModel = ViewModelProvider(this).get(SplashScreenViewModel::class.java)
        return viewModel
    }

    override fun getBindingVariable(): Int {
        return BR.splash_viewmodel
    }

    override val layoutid: Int
        get() = R.layout.activity_splash




}