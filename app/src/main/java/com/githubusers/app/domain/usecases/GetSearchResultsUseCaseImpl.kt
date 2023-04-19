package com.githubusers.app.domain.usecases

import com.githubusers.app.data.repositories.RepositoryRepository
import com.githubusers.app.data.repositories.UserRepository
import com.githubusers.app.domain.models.Repository
import com.githubusers.app.domain.models.User

class GetSearchResultsUseCaseImpl(
    private val userRepository: UserRepository,
    private val repositoryRepository: RepositoryRepository
) : GetSearchResultsUseCase {
    override suspend fun execute(query: String): List<Any> {
        val users = userRepository.searchUsers(query)
        val repositories = repositoryRepository.searchRepositories(query)

        val results = mutableListOf<Any>()
        results.addAll(users)
        results.addAll(repositories)

        results.sortBy {
            when (it) {
                is User -> it.login
                is Repository -> it.name
                else -> ""
            }
        }

        return results
    }
}