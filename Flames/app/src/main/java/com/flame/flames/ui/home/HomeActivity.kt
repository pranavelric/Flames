package com.flame.flames.ui.home

import androidx.lifecycle.ViewModelProvider
import com.flame.flames.BR
import com.flame.flames.R
import com.flame.flames.databinding.ActivityHomeBinding
import com.flame.flames.ui.base.BaseActivity

class HomeActivity : BaseActivity<HomeViewModel, ActivityHomeBinding>() {



    override val layoutid: Int
        get() = R.layout.activity_home

    override fun getViewModel(): HomeViewModel =
        ViewModelProvider(this).get(HomeViewModel::class.java)

    override fun getBindingVariable(): Int = BR.home_binding
}