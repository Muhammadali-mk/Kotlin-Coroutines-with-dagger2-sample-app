package com.mk.recyclerviewtask.presentation.application.di

import android.util.Log
import com.mk.recyclerviewtask.data.datasource.database.PostDatabase
import com.mk.recyclerviewtask.data.datasource.rest.RestProvider
import com.mk.recyclerviewtask.data.datasource.rest.WebService
import com.mk.recyclerviewtask.presentation.application.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ApplicationModule.Providers::class])
object ApplicationModule {
    private val application: Application by lazy { Application() }

    @Module
    object Providers {

        @JvmStatic
        @Provides
        @Singleton
        fun provideDatabase(application: Application): PostDatabase {
            Log.d(
                "my_log",
                "dagger module request database application = $application"
            )
            return PostDatabase.getPostDatabase(application)
        }

        @JvmStatic
        @Provides
        @Singleton
        fun provideApplication(): Application {
            Log.d("application_log", "$application")
            return application
        }

        @JvmStatic
        @Provides
        @Singleton
        fun provideRestProvider(): RestProvider {
            return RestProvider()
        }

        @JvmStatic
        @Provides
        @Singleton
        fun provideWebService(restProvider: RestProvider): WebService {
            return restProvider.getWebService()
        }

    }
}


