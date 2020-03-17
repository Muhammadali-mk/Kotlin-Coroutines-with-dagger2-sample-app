package com.mk.recyclerviewtask.presentation.features.photo.di

import com.mk.recyclerviewtask.presentation.application.di.ApplicationComponent
import com.mk.recyclerviewtask.presentation.features.photo.PhotoFragment
import dagger.Component


@PhotoScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [PhotoModule::class]
)

interface PhotoComponent {

    fun inject(fragment: PhotoFragment)

    companion object {

        fun create(applicationComponent: ApplicationComponent): PhotoComponent =
            DaggerPhotoComponent
                .builder()
                .applicationComponent(applicationComponent)
                .build()
    }

}
