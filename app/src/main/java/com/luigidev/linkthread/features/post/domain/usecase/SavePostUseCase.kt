package com.luigidev.linkthread.features.post.domain.usecase

import com.luigidev.linkthread.core.ResultAPI
import com.luigidev.linkthread.core.models.Post
import com.luigidev.linkthread.features.post.domain.repository.IPostRepository
import javax.inject.Inject

class SavePostUseCase @Inject constructor(private val repository: IPostRepository) {

    operator fun invoke(
        post: Post,
        uploadState: (ResultAPI<String>) -> Unit
    ) = repository.savePost(post, uploadState)
}