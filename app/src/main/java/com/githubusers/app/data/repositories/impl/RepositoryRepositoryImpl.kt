package com.githubusers.app.data.repositories.impl

import com.githubusers.app.data.api.GithubApiService
import com.githubusers.app.data.repositories.RepositoryRepository
import com.githubusers.app.domain.models.Repository

class RepositoryRepositoryImpl(private val apiService: GithubApiService) : RepositoryRepository {
    override suspend fun searchRepositories(query: String): List<Repository> {
        return apiService.api.searchRepositories(query)
    }
}