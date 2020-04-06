package com.mk.recyclerviewtask.presentation.features.details.di

import com.mk.recyclerviewtask.data.repository.details.DetailsRepository
import com.mk.recyclerviewtask.data.repository.details.DetailsRepositoryImpl
import com.mk.recyclerviewtask.domain.post.details.DetailsInteractor
import com.mk.recyclerviewtask.domain.post.details.DetailsInteractorImpl
import dagger.Binds
import dagger.Module

@Module(includes = [DetailsModule.Binders::class])
object DetailsModule {

    @Module
    interface Binders {

        @Binds
        @DetailsScope
        fun bindDetailsRepository(impl: DetailsRepositoryImpl): DetailsRepository

        @Binds
        @DetailsScope
        fun bindDetailsInteractor(impl: DetailsInteractorImpl): DetailsInteractor
    }
}