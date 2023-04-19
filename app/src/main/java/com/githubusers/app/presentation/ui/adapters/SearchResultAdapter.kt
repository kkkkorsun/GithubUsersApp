package com.githubusers.app.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.githubusers.app.domain.models.Repository
import com.githubusers.app.domain.models.User
import com.githubusers.app.presentation.ui.viewholders.RepositoryViewHolder
import com.githubusers.app.presentation.ui.viewholders.UserViewHolder
import com.githubusers.app.presentation.ui.views.RepositoryCardView
import com.githubusers.app.presentation.ui.views.UserCardView

class SearchResultAdapter(
    private val items: List<Any>,
    private val onUserClickListener: (User) -> Unit,
    private val onRepositoryClickListener: (Repository) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_USER = 1
        private const val VIEW_TYPE_REPOSITORY = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_USER -> {
                val userCardView = UserCardView(parent.context)
                UserViewHolder(userCardView, onUserClickListener)
            }
            VIEW_TYPE_REPOSITORY -> {
                val repositoryCardView = RepositoryCardView(parent.context)
                RepositoryViewHolder(repositoryCardView, onRepositoryClickListener)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is UserViewHolder -> holder.bind(items[position] as User)
            is RepositoryViewHolder -> holder.bind(items[position] as Repository)
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is User -> VIEW_TYPE_USER
            is Repository -> VIEW_TYPE_REPOSITORY
            else -> throw IllegalArgumentException("Invalid item type")
        }
    }
}