package com.flame.flames.ui.walkThrough.fragments

import com.flame.flames.BR
import com.flame.flames.R
import com.flame.flames.databinding.SecondWalkFragmentBinding
import com.flame.flames.ui.base.BaseFragment

class SecondWalkFragment : BaseFragment<SecondWalkFragmentBinding, SecondWalkViewModel>() {


    override fun getViewModel(): Class<SecondWalkViewModel> = SecondWalkViewModel::class.java

    override fun getFragmentView(): Int = R.layout.second_walk_fragment
    override fun getBindingVariableId(): Int = BR.second_walk_binding

}