package com.githubusers.app.data.repositories

import com.githubusers.app.domain.models.Repository

interface RepositoryRepository {
    suspend fun searchRepositories(query: String): List<Repository>
}
