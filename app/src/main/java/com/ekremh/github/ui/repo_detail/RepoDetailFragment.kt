package com.ekremh.github.ui.repo_detail

import com.bumptech.glide.Glide
import com.ekremh.github.R
import com.ekremh.github.model.github.UserRepo
import com.ekremh.github.ui.base.BaseFragment
import com.ekremh.github.ui.main.MainActivity
import com.ekremh.github.ui.main.ToolbarClickListener
import kotlinx.android.synthetic.main.fragment_repo_detail.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class RepoDetailFragment: BaseFragment<RepoDetailContract.Presenter>(), RepoDetailContract.View {

    override val layoutId = R.layout.fragment_repo_detail

    override val presenter: RepoDetailContract.Presenter by inject{
        parametersOf(this)
    }
    override fun initializeUI() {
        (baseActivity as? MainActivity)?.toolbarClickListener = this
    }

    override fun setRepo(userRepo: UserRepo) {
        tvOwner.text = userRepo.owner.login
        Glide.with(requireContext()).load(userRepo.owner.avatarUrl).into(ivAvatar)
        tvStarCount.text = getString(R.string.stars, userRepo.stargazersCount.toString())
        tvOpenIssueCount.text = getString(R.string.open_issues, userRepo.openIssuesCount.toString())
        (baseActivity as? MainActivity)?.showFavoriteIcon(userRepo.isFavorite)

    }

    override fun favoriteIconClicked() {
        presenter.favoriteIconClicked()
    }

    override fun added() {
        (baseActivity as? MainActivity)?.setToolbarIcon(R.drawable.ic_baseline_star_24)
    }

    override fun removed() {
        (baseActivity as? MainActivity)?.setToolbarIcon(R.drawable.ic_baseline_star_border_24)
    }
}