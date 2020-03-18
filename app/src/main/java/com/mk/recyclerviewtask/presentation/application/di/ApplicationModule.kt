package com.mk.recyclerviewtask.presentation.application.di

import com.mk.recyclerviewtask.data.datasource.database.PostDatabase
import com.mk.recyclerviewtask.data.datasource.database.PostEntityDao
import com.mk.recyclerviewtask.data.datasource.rest.RestProvider
import com.mk.recyclerviewtask.data.datasource.rest.WebService
import com.mk.recyclerviewtask.presentation.application.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ApplicationModule.Providers::class])
object ApplicationModule {

    @Module
    object Providers {

        @JvmStatic
        @Provides
        @Singleton
        fun provideDatabase(application: Application): PostDatabase {
            return PostDatabase.getPostDatabase(application)
        }

        @JvmStatic
        @Provides
        @Singleton
        fun providePostEntityDao(postDatabase: PostDatabase): PostEntityDao {
            return postDatabase.postEntityDao()
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


