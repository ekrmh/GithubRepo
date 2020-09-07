package com.ekremh.github.rest.github.service

import com.ekremh.github.model.github.UserRepo
import retrofit2.Response

class GithubRepository(private val githubService: GithubService) {
    suspend fun getUserRepositories(user: String): Response<List<UserRepo>> {
        return githubService.getUserRepositories(user)
    }
}