package com.ekremh.github.rest.github.service

import com.ekremh.github.model.github.UserRepo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{user}/repos")
    suspend fun getUserRepositories(@Path("user") user: String): Response<List<UserRepo>>
}