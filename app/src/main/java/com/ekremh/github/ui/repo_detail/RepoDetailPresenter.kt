package com.ekremh.github.ui.repo_detail

import android.os.Bundle
import com.ekremh.github.model.github.UserRepo
import com.ekremh.github.ui.base.MVPPresenter
import com.ekremh.github.utils.SharedPrefHelper

class RepoDetailPresenter(view: RepoDetailContract.View,private val sharedPrefHelper: SharedPrefHelper) : MVPPresenter<RepoDetailContract.View>(view), RepoDetailContract.Presenter {
    lateinit var userRepo: UserRepo

    override fun favoriteIconClicked() {
        if(sharedPrefHelper.isFavorite(userRepo.id.toString())){
            sharedPrefHelper.removeFromList(userRepo.id.toString())
            view?.removed()
        } else {
            sharedPrefHelper.addOFromList(userRepo.id.toString())
            view?.added()
        }
    }

    override fun initialize(extras: Bundle?) {
        super.initialize(extras)
        userRepo = extras?.getSerializable("data") as UserRepo
        view?.setRepo(userRepo)
    }

}