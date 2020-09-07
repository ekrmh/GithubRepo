package com.ekremh.github.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<T : BasePresenter>: AppCompatActivity(), BaseView<T> {

    abstract val layoutId: Int

    abstract val presenter: T

    abstract fun initializeUI()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initializeUI()
        presenter.initialize(savedInstanceState)
    }

    override fun onDestroy() {
        presenter.finalizeView()
        super.onDestroy()
    }

    override fun toastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}