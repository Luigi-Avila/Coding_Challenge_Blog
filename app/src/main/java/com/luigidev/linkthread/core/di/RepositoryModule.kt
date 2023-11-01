package com.luigidev.linkthread.core.di

import com.luigidev.linkthread.features.home.data.HomeRepositoryImp
import com.luigidev.linkthread.features.home.domain.repository.IHomeRepository
import com.luigidev.linkthread.features.post.data.PostRepositoryImp
import com.luigidev.linkthread.features.post.domain.repository.IPostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindHomeRepository(homeRepositoryImp: HomeRepositoryImp): IHomeRepository

    @Binds
    abstract fun bindPostRepository(postRepositoryImp: PostRepositoryImp): IPostRepository
}