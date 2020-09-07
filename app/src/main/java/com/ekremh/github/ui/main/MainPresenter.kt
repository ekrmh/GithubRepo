package com.ekremh.github.ui.main

import android.os.Bundle
import com.ekremh.github.rest.github.service.GithubRepository
import com.ekremh.github.ui.base.MVPPresenter
import com.ekremh.github.ui.main.MainContract

class MainPresenter(view: MainContract.View) : MVPPresenter<MainContract.View>(view), MainContract.Presenter {

}