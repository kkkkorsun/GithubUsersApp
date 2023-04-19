package com.githubusers.app.data.repositories.impl

import com.githubusers.app.data.api.GithubApiService
import com.githubusers.app.data.repositories.RepositoryContentRepository
import com.githubusers.app.domain.models.RepositoryContent

class RepositoryContentRepositoryImpl(private val apiService: GithubApiService) :
    RepositoryContentRepository {
    override suspend fun getRepositoryContent(
        owner: String,
        repo: String,
        path: String
    ): List<RepositoryContent> {
        return apiService.api.getRepositoryContent(owner, repo, path)
    }
}