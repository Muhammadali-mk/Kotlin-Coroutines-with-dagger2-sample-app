package com.mk.recyclerviewtask.presentation.features.details.di

import com.mk.recyclerviewtask.data.repository.post.PostRepository
import com.mk.recyclerviewtask.data.repository.post.PostRepositoryImpl
import com.mk.recyclerviewtask.domain.post.PostInteractor
import com.mk.recyclerviewtask.domain.post.PostInteractorImpl
import dagger.Binds
import dagger.Module

@Module(includes = [DetailsModule.Binders::class])
object DetailsModule {

    @Module
    interface Binders {

        @Binds
        @DetailsScope
        fun bindPostRepository(impl: PostRepositoryImpl): PostRepository

        @Binds
        @DetailsScope
        fun bindPostInteractor(impl: PostInteractorImpl): PostInteractor
    }
}