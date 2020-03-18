package com.mk.recyclerviewtask.presentation.features.post.di

import com.mk.recyclerviewtask.presentation.application.di.ApplicationComponent
import com.mk.recyclerviewtask.presentation.features.details.DetailsFragment
import com.mk.recyclerviewtask.presentation.features.post.PostFragment
import dagger.Component


@PostScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [PostModule::class]
)
interface PostComponent {

    fun inject(fragment: PostFragment)

    companion object {

        fun create(applicationComponent: ApplicationComponent): PostComponent =
            DaggerPostComponent
                .builder()
                .applicationComponent(applicationComponent)
                .build()
    }
}