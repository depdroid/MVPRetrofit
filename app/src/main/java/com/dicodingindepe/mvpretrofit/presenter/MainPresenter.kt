package com.dicodingindepe.mvpretrofit.presenter

import android.util.Log
import com.dicodingindepe.mvpretrofit.model.User
import com.dicodingindepe.mvpretrofit.utils.GitHubService
import com.dicodingindepe.mvpretrofit.view.MainView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainPresenter(val mainView: MainView, val service: GitHubService) {


    fun getUsers() {

            service.users().enqueue(object : Callback<List<User>> {
                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    Log.d("error", t.message)
                }

                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    if (response.isSuccessful) {
                        val responbody = response.body()
                        val data = responbody?.toMutableList()?: mutableListOf()
                        mainView.showLoading()
                        mainView.showUsers(data)
                        mainView.hideLoading()
                    }
                }

            })






    }
}