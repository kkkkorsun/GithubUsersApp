package com.githubusers.app.presentation.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.githubusers.app.domain.usecases.GetSearchResultsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val getSearchResultsUseCase: GetSearchResultsUseCase) : ViewModel() {
    private val _searchResults = MutableStateFlow<List<Any>>(emptyList())
    val searchResults: StateFlow<List<Any>> = _searchResults

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun search(query: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _searchResults.value = getSearchResultsUseCase.execute(query)
            _isLoading.value = false
        }
    }
}