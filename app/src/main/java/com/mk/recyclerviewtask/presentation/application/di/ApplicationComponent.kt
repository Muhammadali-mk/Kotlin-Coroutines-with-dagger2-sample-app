package com.mk.recyclerviewtask.presentation.application.di

import com.mk.recyclerviewtask.data.datasource.database.PostDatabase
import com.mk.recyclerviewtask.data.datasource.database.PostEntityDao
import com.mk.recyclerviewtask.data.datasource.rest.WebService
import com.mk.recyclerviewtask.presentation.application.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun postDatabase(): PostDatabase

    fun postEntityDao(): PostEntityDao

    fun webService(): WebService

    fun inject(app: Application)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }

    companion object {
        private var component: ApplicationComponent? = null

        fun create(application: Application): ApplicationComponent {
            component = DaggerApplicationComponent.factory().create(application)
            return checkNotNull(component)
        }

        fun get(): ApplicationComponent =
            checkNotNull(component)
    }
}