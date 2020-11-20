package com.flame.flames.ui.walkThrough.fragments

import com.flame.flames.BR
import com.flame.flames.R
import com.flame.flames.databinding.FirstWalkFragmentBinding
import com.flame.flames.ui.base.BaseFragment

class FirstWalkFragment : BaseFragment<FirstWalkFragmentBinding, FirstWalkViewModel>() {


    override fun getViewModel(): Class<FirstWalkViewModel> = FirstWalkViewModel::class.java

    override fun getFragmentView(): Int = R.layout.first_walk_fragment
    override fun getBindingVariableId(): Int = BR.first_walk_binding
}