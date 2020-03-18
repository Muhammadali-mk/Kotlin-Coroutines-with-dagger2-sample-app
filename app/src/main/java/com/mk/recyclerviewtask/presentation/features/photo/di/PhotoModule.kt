package com.mk.recyclerviewtask.presentation.features.photo.di

import com.mk.recyclerviewtask.data.repository.photo.PhotoRepository
import com.mk.recyclerviewtask.data.repository.photo.PhotoRepositoryImpl
import com.mk.recyclerviewtask.data.repository.post.PostRepositoryImpl_Factory
import com.mk.recyclerviewtask.domain.photo.PhotoInteractor
import com.mk.recyclerviewtask.domain.photo.PhotoInteractorImpl
import dagger.Binds
import dagger.Module

@Module(includes = [PhotoModule.Binders::class])
object PhotoModule {

    @Module
    interface Binders {

        @Binds
        @PhotoScope
        fun bindPhotoRepository(impl: PhotoRepositoryImpl): PhotoRepository

        @Binds
        @PhotoScope
        fun bindPhotoInteractor(impl: PhotoInteractorImpl): PhotoInteractor
    }
}
