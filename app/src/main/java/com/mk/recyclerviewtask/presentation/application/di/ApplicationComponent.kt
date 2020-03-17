package com.mk.recyclerviewtask.presentation.application.di

import com.mk.recyclerviewtask.data.datasource.database.PostDatabase
import com.mk.recyclerviewtask.data.datasource.rest.WebService
import com.mk.recyclerviewtask.presentation.application.Application
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun injectApp(app: Application)

    fun provideWebService(): WebService

    fun provideDatabase(): PostDatabase

    /*  @Component.Builder
      interface Builder {

          @BindsInstance
          fun application(app: Application): Builder

          fun build(): ApplicationComponent
      }*/

    companion object {
        @Volatile
        private var component: ApplicationComponent? = null

        fun createOrGet(): ApplicationComponent {
            return if (component != null) checkNotNull(component)
            else synchronized(this) {
                if (component != null) return checkNotNull(component)
                else component =
                    DaggerApplicationComponent
                        .builder()
                        .fac
                        .build()
                return@synchronized checkNotNull(component)
            }
        }
    }
}