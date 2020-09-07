package com.ekremh.github.ui.main

import com.ekremh.github.ui.base.BasePresenter
import com.ekremh.github.ui.base.BaseView

class MainContract {
    interface View: BaseView<Presenter> {
    }

    interface Presenter: BasePresenter {
    }
}