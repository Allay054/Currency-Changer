package com.allaykhalil.apicallingwithcoroutinesandhilt.interfaces

interface BaseNavigator {
    fun goBack()
    fun showSuccessMessage(successMessage: String?)
    fun showErrorMessage(error: String?)

    fun isNetworkConnected(): Boolean {
        return false
    }

    fun showProgressBar()

    fun hideProgressBar()
}