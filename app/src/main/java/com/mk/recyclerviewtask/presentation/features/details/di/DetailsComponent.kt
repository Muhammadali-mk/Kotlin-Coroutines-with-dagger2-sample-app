package com.mk.recyclerviewtask.presentation.features.details.di

import com.mk.recyclerviewtask.presentation.application.di.ApplicationComponent
import com.mk.recyclerviewtask.presentation.features.details.DetailsFragment
import com.mk.recyclerviewtask.presentation.features.post.di.DaggerPostComponent
import com.mk.recyclerviewtask.presentation.features.post.di.PostComponent
import dagger.Component

@DetailsScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [DetailsModule::class]
)
interface DetailsComponent {

    fun inject(fragment: DetailsFragment)

    companion object {

        fun create(applicationComponent: ApplicationComponent): DetailsComponent =
            DaggerDetailsComponent
                .builder()
                .applicationComponent(applicationComponent)
                .build()
    }
}