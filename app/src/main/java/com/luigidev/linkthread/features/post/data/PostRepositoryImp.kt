package com.luigidev.linkthread.features.post.data

import com.luigidev.linkthread.core.ResultAPI
import com.luigidev.linkthread.features.post.data.network.PostClient
import com.luigidev.linkthread.core.models.Post
import com.luigidev.linkthread.features.post.domain.repository.IPostRepository
import javax.inject.Inject

class PostRepositoryImp @Inject constructor(private val client: PostClient) : IPostRepository {

    override fun savePost(
        post: Post,
        uploadState: (ResultAPI<String>) -> Unit
    ) = client.uploadPost(post, uploadState)
}