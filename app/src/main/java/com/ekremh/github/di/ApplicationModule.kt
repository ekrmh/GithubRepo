package com.ekremh.github.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.ekremh.github.utils.AppConstants
import com.ekremh.github.utils.SharedPrefHelper
import com.google.gson.Gson
import org.koin.dsl.module

val applicationModule = module {
    single {
        get<Context>().getSharedPreferences(AppConstants.SHARED_PREF_FILE_NAME,
            MODE_PRIVATE)
    }

    single {
        Gson()
    }
    single {
        SharedPrefHelper(get(), get())
    }
}


