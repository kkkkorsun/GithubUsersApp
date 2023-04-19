package com.githubusers.app.data.repositories

import com.githubusers.app.domain.models.RepositoryContent

interface RepositoryContentRepository {
    suspend fun getRepositoryContent(
        owner: String,
        repo: String,
        path: String
    ): List<RepositoryContent>
}