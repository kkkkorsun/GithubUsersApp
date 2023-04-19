package com.githubusers.app.domain.usecases

interface GetSearchResultsUseCase {
    suspend fun execute(query: String): List<Any>
}