package com.ekremh.github.ui.base

interface BaseView<T : BasePresenter> {
    fun toastMessage(message: String)
}