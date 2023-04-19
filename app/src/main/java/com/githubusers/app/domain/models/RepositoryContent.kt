package com.githubusers.app.domain.models

data class RepositoryContent(
    val name: String,
    val path: String,
    val type: String,
    val size: Int,
    val downloadUrl: String?,
    val htmlUrl: String
)