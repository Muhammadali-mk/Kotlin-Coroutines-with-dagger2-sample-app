package com.mk.recyclerviewtask.data.repository.post

import com.mk.recyclerviewtask.data.datasource.database.PostEntityDao
import com.mk.recyclerviewtask.data.datasource.rest.WebService
import com.mk.recyclerviewtask.data.mapper.map
import com.mk.recyclerviewtask.data.mapper.mapToEntities
import com.mk.recyclerviewtask.data.model.post.Post
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postEntityDao: PostEntityDao,
    private val webService: WebService
) : PostRepository {

    @ExperimentalCoroutinesApi
    override fun getPosts(): Flow<List<Post>> {
        return flow { emit(webService.getPosts()) }
            .onEach { postEntityDao.insert(it.mapToEntities()) }
            .map { it.map() }
    }
}


