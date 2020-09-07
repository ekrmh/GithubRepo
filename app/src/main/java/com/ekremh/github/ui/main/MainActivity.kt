package com.ekremh.github.ui.main

import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.ekremh.github.R
import com.ekremh.github.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : BaseActivity<MainContract.Presenter>(), MainContract.View {

    override val layoutId = R.layout.activity_main

    override val presenter: MainContract.Presenter by inject {
        parametersOf(this)
    }

    var toolbarClickListener: ToolbarClickListener? =null

    override fun initializeUI() {
        setSupportActionBar(toolbar)

        val navController = findNavController(R.id.fragmentContainer)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController, appBarConfiguration)

        toolbar.ivFavorite.setOnClickListener {
            toolbarClickListener?.favoriteIconClicked()
        }

    }

    fun showFavoriteIcon(isFavorite: Boolean) {
        toolbar.ivFavorite.visibility = View.VISIBLE
        toolbar.ivFavorite.setImageResource(
            if (isFavorite) R.drawable.ic_baseline_star_24
            else R.drawable.ic_baseline_star_border_24
        )
    }

    fun hideFavoriteIcon(){
        toolbar.ivFavorite.visibility = View.GONE
    }

    fun setToolbarIcon(icon: Int) {
        toolbar.ivFavorite.setImageResource(icon)
    }


}