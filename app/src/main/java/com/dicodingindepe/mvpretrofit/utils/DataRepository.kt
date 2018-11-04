package com.dicodingindepe.mvpretrofit.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataRepository {
    fun create(): GitHubService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.github.com/")
            .build()

        return retrofit.create(GitHubService::class.java)
    }
}