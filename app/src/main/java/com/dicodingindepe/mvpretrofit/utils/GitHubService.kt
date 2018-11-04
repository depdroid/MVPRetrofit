package com.dicodingindepe.mvpretrofit.utils

import com.dicodingindepe.mvpretrofit.model.User
import retrofit2.Call
import retrofit2.http.GET

interface GitHubService {
    @GET("users")
    fun users(): Call<List<User>>
}