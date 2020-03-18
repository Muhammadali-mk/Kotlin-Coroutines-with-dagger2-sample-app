package com.mk.recyclerviewtask.presentation.global.di

import com.mk.recyclerviewtask.presentation.application.di.ApplicationComponent
import com.mk.recyclerviewtask.presentation.global.MainActivity
import dagger.Component
@GlobalScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [GlobalModule::class]
)
interface GlobalComponent {

    fun inject(activity: MainActivity)

    companion object {
        @Volatile
        private var component: GlobalComponent? = null

        fun createOrGet(applicationComponent: ApplicationComponent): GlobalComponent {
            return if (component != null) checkNotNull(component)
            else synchronized(this) {
                if (component != null) return checkNotNull(component)
                else component =
                    DaggerGlobalComponent
                        .builder()
                        .applicationComponent(applicationComponent)
                        .build()
                return@synchronized checkNotNull(component)
            }
        }
    }
}