package com.ekremh.github.di


import com.ekremh.github.ui.main.MainContract
import com.ekremh.github.ui.main.MainPresenter
import com.ekremh.github.ui.repo_detail.RepoDetailContract
import com.ekremh.github.ui.repo_detail.RepoDetailPresenter
import com.ekremh.github.ui.repo_list.RepoListContract
import com.ekremh.github.ui.repo_list.RepoListPresenter
import org.koin.dsl.module

val presenterModule = module {
    factory { (view: MainContract.View) ->  MainPresenter(view) as MainContract.Presenter }
    factory { (view: RepoListContract.View) ->  RepoListPresenter(view, get(), get()) as RepoListContract.Presenter }
    factory { (view: RepoDetailContract.View) ->  RepoDetailPresenter(view, get()) as RepoDetailContract.Presenter }
}