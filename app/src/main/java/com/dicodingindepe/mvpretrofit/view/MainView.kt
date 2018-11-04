package com.dicodingindepe.mvpretrofit.view

import com.dicodingindepe.mvpretrofit.model.User

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showUsers(data:List<User>)
}