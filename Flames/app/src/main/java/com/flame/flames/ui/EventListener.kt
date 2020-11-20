package com.flame.flames.ui

interface EventListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message: String)

}