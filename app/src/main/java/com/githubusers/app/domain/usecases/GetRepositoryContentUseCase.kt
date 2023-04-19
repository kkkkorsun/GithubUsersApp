package com.githubusers.app.domain.usecases

import com.githubusers.app.domain.models.RepositoryContent

interface GetRepositoryContentUseCase {
    suspend fun execute(owner: String, repo: String, path: String): List<RepositoryContent>
}