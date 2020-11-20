package com.flame.flames.ui.walkThrough

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.flame.flames.BR
import com.flame.flames.R
import com.flame.flames.databinding.ActivityWalkthroughBinding
import com.flame.flames.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_walkthrough.*


class WalkthroughActivity : BaseActivity<WalkthroughViewmodel, ActivityWalkthroughBinding>() {
    lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var viewModel: WalkthroughViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, 1)
        pager.adapter = viewPagerAdapter
    }

    override fun getViewModel(): WalkthroughViewmodel {
        viewModel = ViewModelProvider(this).get(WalkthroughViewmodel::class.java)
        return viewModel
    }

    override fun getBindingVariable(): Int {
        return BR.walk_view_model
    }

    override val layoutid: Int
        get() = R.layout.activity_walkthrough


}