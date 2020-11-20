package com.flame.flames.ui.walkThrough.fragments

import android.content.Intent
import android.view.View
import com.flame.flames.ui.base.BaseViewModel
import com.flame.flames.ui.home.HomeActivity
import com.flame.flames.utils.transitionAnimationBundle

class SecondWalkViewModel : BaseViewModel() {


    fun onSkipClick(view: View) {

        Intent(
            view.context,
            HomeActivity::class.java,
        ).also {

            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            view.context.startActivity(it, view.context.transitionAnimationBundle())
        }

    }


}