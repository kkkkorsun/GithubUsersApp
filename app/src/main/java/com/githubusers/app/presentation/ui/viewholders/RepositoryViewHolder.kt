package com.githubusers.app.presentation.ui.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.githubusers.app.domain.models.Repository
import com.githubusers.app.presentation.ui.views.RepositoryCardView

class RepositoryViewHolder(
    private val repositoryCardView: RepositoryCardView,
    private val onRepositoryClickListener: (Repository) -> Unit
) : RecyclerView.ViewHolder(repositoryCardView) {
    fun bind(repository: Repository) {
        repositoryCardView.setRepository(repository)
        repositoryCardView.setOnClickListener { onRepositoryClickListener(repository) }
    }
}