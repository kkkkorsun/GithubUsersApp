package com.githubusers.app.data.repositories.impl

import com.githubusers.app.data.api.GithubApiService
import com.githubusers.app.data.repositories.UserRepository
import com.githubusers.app.domain.models.User

class UserRepositoryImpl(private val apiService: GithubApiService) : UserRepository {
    override suspend fun searchUsers(query: String): List<User> {
        return apiService.api.searchUsers(query)
    }
}