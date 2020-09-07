package com.ekremh.github.di

import com.ekremh.github.rest.github.service.GithubService
import com.ekremh.github.rest.github.service.GithubRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val repositoryModule = module {
    single { get<Retrofit>().create(GithubService::class.java) }

    factory {
        GithubRepository(get())
    }
}