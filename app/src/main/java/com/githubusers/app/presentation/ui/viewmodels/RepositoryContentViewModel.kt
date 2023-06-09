package com.githubusers.app.presentation.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.githubusers.app.domain.usecases.GetRepositoryContentUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RepositoryContentViewModel(private val getRepositoryContentUseCase: GetRepositoryContentUseCase) :
    ViewModel() {
    private val _repositoryContent = MutableStateFlow<List<Any>>(emptyList())
    val repositoryContent: StateFlow<List<Any>> = _repositoryContent

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