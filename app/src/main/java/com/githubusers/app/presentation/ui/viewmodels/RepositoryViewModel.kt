package com.githubusers.app.presentation.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.githubusers.app.domain.models.RepositoryContent
import com.githubusers.app.domain.usecases.GetRepositoryContentUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RepositoryViewModel(private val getRepositoryContentUseCase: GetRepositoryContentUseCase) :
    ViewModel() {
    private val _repositoryContent = MutableStateFlow<List<RepositoryContent>>(emptyList())
    val repositoryContent: StateFlow<List<RepositoryContent>> = _repositoryContent

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun loadContent(owner: String, repo: String, path: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _repositoryContent.value = getRepositoryContentUseCase.execute(owner, repo, path)
            _isLoading.value = false
        }
    }
}