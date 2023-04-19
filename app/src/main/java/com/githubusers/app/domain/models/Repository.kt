package com.githubusers.app.domain.models

data class Repository(
    val id: Long,
    val name: String,
    val fullName: String,
    val htmlUrl: String,
    val description: String?,
    val forksCount: Int
)