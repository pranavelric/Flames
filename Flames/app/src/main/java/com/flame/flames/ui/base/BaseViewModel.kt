package com.flame.flames.ui.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel


abstract class BaseViewModel : ViewModel() {

    private val mIsLoading = ObservableBoolean()



    fun setIsLoading(isLoading: Boolean) {
        mIsLoading.set(isLoading)
    }

}