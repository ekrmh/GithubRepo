package com.ekremh.github.ui.repo_detail

import com.ekremh.github.model.github.UserRepo
import com.ekremh.github.ui.base.BasePresenter
import com.ekremh.github.ui.base.BaseView
import com.ekremh.github.ui.main.ToolbarClickListener

class RepoDetailContract {
    interface View: BaseView<Presenter>, ToolbarClickListener {
        fun setRepo(userRepo: UserRepo)
        fun added()
        fun removed()
    }

    interface Presenter: BasePresenter {
        fun favoriteIconClicked()
    }
}