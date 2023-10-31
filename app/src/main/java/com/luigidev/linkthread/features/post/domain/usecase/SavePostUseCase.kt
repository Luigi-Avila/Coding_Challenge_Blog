package com.luigidev.linkthread.features.post.domain.usecase

import com.luigidev.linkthread.core.ResultAPI
import com.luigidev.linkthread.features.post.data.PostRepositoryImp
import com.luigidev.linkthread.core.models.Post

class SavePostUseCase {

    private val repository = PostRepositoryImp()

    operator fun invoke(
        post: Post,
        uploadState: (ResultAPI<String>) -> Unit
    ) = repository.savePost(post, uploadState)
}