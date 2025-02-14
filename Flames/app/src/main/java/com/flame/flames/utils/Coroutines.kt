package com.flame.flames.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


object Coroutines {

    fun mainWithDelay(work: suspend (() -> Unit)) {
        CoroutineScope(Dispatchers.Main).launch {
            delay(4500)
            work()
        }
    }

}