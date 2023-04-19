package com.githubusers.app.domain.models

data class User(
    val login: String,
    val avatarUrl: String?,
    val htmlUrl: String,
    val score: Float
)