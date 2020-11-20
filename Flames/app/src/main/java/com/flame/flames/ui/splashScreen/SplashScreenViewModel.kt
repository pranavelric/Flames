package com.flame.flames.ui.splashScreen

import android.content.Context
import android.content.Intent
import com.flame.flames.ui.base.BaseViewModel
import com.flame.flames.ui.walkThrough.WalkthroughActivity
import com.flame.flames.utils.Coroutines
import com.flame.flames.utils.transitionAnimationBundle

class SplashScreenViewModel : BaseViewModel() {


    fun goToWalkThrough(context: Context) {
        Coroutines.mainWithDelay {
            Intent(context, WalkthroughActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                context.startActivity(it, context.transitionAnimationBundle())
            }

        }

    }

}