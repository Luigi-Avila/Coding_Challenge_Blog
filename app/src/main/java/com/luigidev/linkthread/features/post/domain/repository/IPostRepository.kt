package com.luigidev.linkthread.features.post.domain.repository

import com.luigidev.linkthread.core.ResultAPI
import com.luigidev.linkthread.features.post.domain.models.Post

interface IPostRepository {
    fun savePost(post: Post, uploadState: (ResultAPI<String>) -> Unit)
}