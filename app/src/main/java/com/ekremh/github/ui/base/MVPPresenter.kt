package com.ekremh.github.ui.base

import android.os.Bundle
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

abstract class MVPPresenter<T : BaseView<*>>(protected var view: T?) : BasePresenter,
    CoroutineScope {

    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + IO


    override fun initialize(extras: Bundle?) {}

    override fun finalizeView() {
    }

    protected fun <T> networkRequest(block: suspend () -> Response<T>, successListener: ((T) -> Unit)? = null, failureListener: ((String) -> Unit)? = null) {
        try {
            launch {
                val response = block.invoke()
                withContext(Main){
                    if (response.isSuccessful){
                        response.body()?.let {
                            successListener?.invoke(it)
                        } ?: failureListener?.invoke("Empty body")
                    } else {
                        failureListener?.invoke(response.message())
                    }
                }
            }
        } catch (exception: Exception) {
            failureListener?.invoke(exception.message ?: "Something went wrong")
        }

    }
}