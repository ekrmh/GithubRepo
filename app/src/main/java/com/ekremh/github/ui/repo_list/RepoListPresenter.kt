package com.ekremh.github.ui.repo_list

import com.ekremh.github.model.github.UserRepo
import com.ekremh.github.rest.github.service.GithubRepository
import com.ekremh.github.ui.base.MVPPresenter
import com.ekremh.github.utils.SharedPrefHelper

class RepoListPresenter(
    view: RepoListContract.View,
    private val githubRepository: GithubRepository,
    private val sharedPrefHelper: SharedPrefHelper
) : MVPPresenter<RepoListContract.View>(view), RepoListContract.Presenter {

    var userRepoList: List<UserRepo>? = null

    override fun getUserRepositories(user: String) {
        networkRequest({
            githubRepository.getUserRepositories(user)
        }, successListener = {
            val list = it.toMutableList()
            list.forEach { user ->
                user.isFavorite = sharedPrefHelper.isFavorite(user.id.toString())
            }
            userRepoList = list
            userRepoList?.let { repoList ->
                view?.showUserRepositories(repoList)
            }
        }, failureListener = {
            view?.toastMessage(it)
        })
    }


    override fun syncFavorite() {
        userRepoList?.let {
            val list = it.toMutableList()
            list.forEach { user ->
                user.isFavorite = sharedPrefHelper.isFavorite(user.id.toString())
            }
            userRepoList = list
            view?.showUserRepositories(it)
        }
    }
}