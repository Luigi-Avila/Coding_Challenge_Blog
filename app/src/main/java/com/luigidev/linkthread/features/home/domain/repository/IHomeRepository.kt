package com.luigidev.linkthread.features.home.domain.repository

import com.luigidev.linkthread.core.ResultAPI
import com.luigidev.linkthread.core.models.Post

interface IHomeRepository {
    fun getPosts(dataState: (ResultAPI<List<Post>>) -> Unit)
}