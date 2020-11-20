package com.flame.flames.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.flame.flames.R
import com.flame.flames.databinding.BottomSheetBinding
import com.flame.flames.ui.home.HomeViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet.view.*


class MyBottomSheetDialogFragment(private val imgRes: Int) : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding: BottomSheetBinding =
            DataBindingUtil.inflate(inflater, R.layout.bottom_sheet, container, false)
        val viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.bmSheetBinding = viewModel

        binding.root.flame_result.background =
            activity?.let { ContextCompat.getDrawable(it, imgRes) }

        return binding.root


    }


}