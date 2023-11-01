package com.luigidev.linkthread.features.home.domain.usecase

import com.luigidev.linkthread.core.ResultAPI
import com.luigidev.linkthread.core.models.Post
import com.luigidev.linkthread.features.home.domain.repository.IHomeRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val repository: IHomeRepository) {
    operator fun invoke(dataState: (ResultAPI<List<Post>>) -> Unit) = repository.getPosts(dataState)

}