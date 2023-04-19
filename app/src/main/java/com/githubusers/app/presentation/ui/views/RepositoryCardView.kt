package com.githubusers.app.presentation.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import com.githubusers.app.databinding.ItemRepositoryCardBinding
import com.githubusers.app.domain.models.Repository

class RepositoryCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {
    private val binding = ItemRepositoryCardBinding.inflate(LayoutInflater.from(context), this, true)

    fun setRepository(repository: Repository) {
        binding.apply {
            repositoryNameTextView.text = repository.name
            forksCountTextView.text = repository.forksCount.toString()
            descriptionTextView.text = repository.description
        }
    }
}