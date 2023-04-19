package com.githubusers.app.domain.usecases

import com.githubusers.app.data.repositories.RepositoryContentRepository
import com.githubusers.app.domain.models.RepositoryContent

class GetRepositoryContentUseCaseImpl(
    private val repositoryContentRepository: RepositoryContentRepository
) : GetRepositoryContentUseCase {
    override suspend fun execute(
        owner: String,
        repo: String,
        path: String
    ): List<RepositoryContent> {
        return repositoryContentRepository.getRepositoryContent(owner, repo, path)
    }
}