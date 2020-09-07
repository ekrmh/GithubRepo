package com.ekremh.github.ui.repo_list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ekremh.github.R
import com.ekremh.github.model.github.UserRepo
import kotlinx.android.synthetic.main.item_repo_list.view.*

class RepoListAdapter(
    private val detailClickListener: (item: UserRepo) -> Unit
) : RecyclerView.Adapter<RepoListAdapter.ViewHolder>() {

    private var list: List<UserRepo> = emptyList()

    fun setData(list: List<UserRepo>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_repo_list, parent, false)
        ).apply {
            itemView.setOnClickListener { detailClickListener(list[adapterPosition]) }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bind(userRepo: UserRepo) {
            itemView.tvRepoName.text = userRepo.name
            itemView.ivFavorite.visibility = if (userRepo.isFavorite) View.VISIBLE else View.INVISIBLE
        }
    }
}