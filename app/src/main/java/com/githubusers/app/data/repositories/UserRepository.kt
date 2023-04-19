package com.githubusers.app.data.repositories

import com.githubusers.app.domain.models.User

interface UserRepository {
    suspend fun searchUsers(query: String): List<User>
}