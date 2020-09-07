package com.ekremh.github.ui.repo_list

import com.ekremh.github.model.github.UserRepo
import com.ekremh.github.ui.base.BasePresenter
import com.ekremh.github.ui.base.BaseView

class RepoListContract {
    interface View: BaseView<Presenter> {
        fun showUserRepositories(userRepoList: List<UserRepo>)
    }

    interface Presenter: BasePresenter {
        fun getUserRepositories(user: String)
        fun syncFavorite()

    }
}