package com.luigidev.linkthread.features.home.data

import com.luigidev.linkthread.core.ResultAPI
import com.luigidev.linkthread.core.models.Post
import com.luigidev.linkthread.features.home.data.network.HomeClient
import com.luigidev.linkthread.features.home.domain.repository.IHomeRepository
import javax.inject.Inject

class HomeRepositoryImp @Inject constructor( private val client: HomeClient) : IHomeRepository {

    override fun getPosts(dataState: (ResultAPI<List<Post>>) -> Unit) = client.getPosts(dataState)
}