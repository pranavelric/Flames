package com.flame.flames.ui.base

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.flame.flames.ui.EventListener
import com.flame.flames.utils.setFullScreen
import com.flame.flames.utils.setFullScreenForNotch

import java.lang.reflect.ParameterizedType

abstract class BaseActivity<ViewModel : BaseViewModel, Binding : ViewDataBinding> :
    AppCompatActivity(),
    EventListener {


    lateinit var binding: Binding
    private var viewModel: ViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setFullScreenForNotch()
        performViewModelBinding()

    }

    @get:LayoutRes
    abstract val layoutid: Int

    abstract fun getViewModel(): ViewModel


    abstract fun getBindingVariable(): Int

    private fun performViewModelBinding() {


        binding = DataBindingUtil.setContentView(this, layoutid)
        this.viewModel = viewModel ?: getViewModel()
        binding.setVariable(getBindingVariable(), viewModel)
        binding.executePendingBindings()

    }

    private fun getViewModelClass(): Class<ViewModel> {
        val type =
            (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return type as Class<ViewModel>
    }


    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (hasFocus) {
            setFullScreen()
        }
    }

    override fun onFailure(message: String) {
    }

    override fun onStarted() {
    }

    override fun onSuccess() {
    }


}