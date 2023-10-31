package com.luigidev.linkthread.features.post.domain.models

data class Post(
    val id: String? = null,
    val title: String,
    val author: String,
    val dateTime: String,
    val content: String,
)
