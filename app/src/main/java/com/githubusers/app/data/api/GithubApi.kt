package com.githubusers.app.data.api

import com.githubusers.app.domain.models.Repository
import com.githubusers.app.domain.models.RepositoryContent
import com.githubusers.app.domain.models.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {
    @GET("search/users")
    suspend fun searchUsers(@Query("q") query: String): List<User>

    @GET("search/repositories")
    suspend fun searchRepositories(@Query("q") query: String): List<Repository>

    @GET("repos/{owner}/{repo}/contents/{path}")
    suspend fun getRepositoryContent(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("path") path: String
    ): List<RepositoryContent>
}