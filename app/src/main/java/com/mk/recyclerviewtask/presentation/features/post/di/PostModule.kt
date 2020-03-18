package com.mk.recyclerviewtask.presentation.features.post.di

import com.mk.recyclerviewtask.data.repository.post.PostRepository
import com.mk.recyclerviewtask.data.repository.post.PostRepositoryImpl
import com.mk.recyclerviewtask.domain.post.PostInteractor
import com.mk.recyclerviewtask.domain.post.PostInteractorImpl
import dagger.Binds
import dagger.Module

@Module(includes = [PostModule.Binders::class])
object PostModule {

    @Module
    interface Binders {

        @Binds
        @PostScope
        fun bindPostRepository(impl: PostRepositoryImpl): PostRepository

        @Binds
        @PostScope
        fun bindPostInteractor(impl: PostInteractorImpl): PostInteractor
    }
}