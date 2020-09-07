package com.ekremh.github.ui.repo_list

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ekremh.github.R
import com.ekremh.github.model.github.UserRepo
import com.ekremh.github.ui.base.BaseFragment
import com.ekremh.github.ui.main.MainActivity
import com.ekremh.github.ui.repo_list.adapter.RepoListAdapter
import kotlinx.android.synthetic.main.fragment_repo_list.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class RepoListFragment : BaseFragment<RepoListContract.Presenter>(), RepoListContract.View {

    override val layoutId = R.layout.fragment_repo_list

    override val presenter: RepoListContract.Presenter by inject {
        parametersOf(this)
    }

    private val repoListAdapter: RepoListAdapter by lazy {
        RepoListAdapter {
            val action =
                RepoListFragmentDirections
                    .actionRepoListFragmentToRepoDetailFragment(it, it.name)
            findNavController().navigate(action)
        }
    }

    override fun initializeUI() {
        (baseActivity as? MainActivity)?.hideFavoriteIcon()

        btnSubmit.setOnClickListener {
            val username = edtUsername.text.toString().trim()
            if (username.isBlank() || username.isEmpty()) {
                edtUsername.error = getString(R.string.empty_error)
                return@setOnClickListener
            }
            presenter.getUserRepositories(username)

        }
        presenter.syncFavorite()
        rcvUserRepo.layoutManager = LinearLayoutManager(requireContext())

        rcvUserRepo.adapter = repoListAdapter
    }

    override fun showUserRepositories(userRepoList: List<UserRepo>) {
        repoListAdapter.setData(userRepoList)
    }
}