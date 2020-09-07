package com.ekremh.github

import android.app.Application
import com.ekremh.github.di.applicationModule
import com.ekremh.github.di.networkModule
import com.ekremh.github.di.presenterModule
import com.ekremh.github.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@MyApplication)
            // declare modules
            modules(
                applicationModule,
                networkModule,
                repositoryModule,
                presenterModule
            )
        }
    }
}