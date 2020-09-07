package com.ekremh.github.ui.base

import android.os.Bundle

interface BasePresenter {
    fun initialize(extras: Bundle?)
    fun finalizeView()
}