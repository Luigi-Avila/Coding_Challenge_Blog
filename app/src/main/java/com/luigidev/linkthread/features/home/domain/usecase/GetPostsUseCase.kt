package com.luigidev.linkthread.features.home.domain.usecase

import com.luigidev.linkthread.core.ResultAPI
import com.luigidev.linkthread.core.models.Post
import com.luigidev.linkthread.features.home.data.HomeRepositoryImp

class GetPostsUseCase {

    private val repository = HomeRepositoryImp()

    operator fun invoke(dataState: (ResultAPI<List<Post>>) -> Unit) = repository.getPosts(dataState)

}