package com.githubusers.app.presentation.ui.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.githubusers.app.domain.models.User
import com.githubusers.app.presentation.ui.views.UserCardView

class UserViewHolder(
    private val userCardView: UserCardView,
    private val onUserClickListener: (User) -> Unit
) : RecyclerView.ViewHolder(userCardView) {
    fun bind(user: User) {
        userCardView.setUser(user)
        userCardView.setOnClickListener { onUserClickListener(user) }
    }
}