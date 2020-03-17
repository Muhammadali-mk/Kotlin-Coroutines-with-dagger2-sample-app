package com.mk.recyclerviewtask.presentation.features.post.di

import com.mk.recyclerviewtask.data.datasource.database.PostDatabase
import com.mk.recyclerviewtask.data.datasource.rest.WebService
import com.mk.recyclerviewtask.data.repository.post.PostRepository
import com.mk.recyclerviewtask.data.repository.post.PostRepositoryImpl
import com.mk.recyclerviewtask.domain.post.PostInteractor
import com.mk.recyclerviewtask.domain.post.PostInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [PostModule.Binders::class])
object PostModule {

    @JvmStatic
    @Provides
    @PostScope
    fun providePostRepository(database: PostDatabase, webService: WebService): PostRepository {
        return PostRepositoryImpl(
            postEntityDao = database.postEntityDao(),
            webService = webService
        )
    }

    @Module
    interface Binders {
       /* @Binds
        @PostScope
        fun bindPostRepository(impl: PostRepositoryImpl): PostRepository
*/
        @Binds
        @PostScope
        fun bindPostInteractor(impl: PostInteractorImpl): PostInteractor
    }
}