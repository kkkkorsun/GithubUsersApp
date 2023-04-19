package com.githubusers.app.presentation.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import com.githubusers.app.databinding.ItemUserCardBinding
import com.githubusers.app.domain.models.User

class UserCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {
    private val binding = ItemUserCardBinding.inflate(LayoutInflater.from(context), this, true)

    fun setUser(user: User) {
        binding.apply {
            //avatarImageView.load(user.avatarUrl)
            usernameTextView.text = user.login
            scoreTextView.text = user.score.toString()
        }
    }
}