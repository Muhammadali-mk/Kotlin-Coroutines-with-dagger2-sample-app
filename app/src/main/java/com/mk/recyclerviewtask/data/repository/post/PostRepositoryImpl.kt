package com.mk.recyclerviewtask.data.repository.post

import com.mk.recyclerviewtask.data.datasource.database.PostEntityDao
import com.mk.recyclerviewtask.data.datasource.rest.WebService
import com.mk.recyclerviewtask.data.mapper.map
import com.mk.recyclerviewtask.data.mapper.mapToEntities
import com.mk.recyclerviewtask.data.mapper.mapToEntity
import com.mk.recyclerviewtask.data.model.post.Post
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
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

    @FlowPreview
    override fun getPostById(id: Int): Flow<Post> {
        return flow { emit(postEntityDao.getPostById(id)) }
            .flatMapConcat { it ->
                return@flatMapConcat if (it != null) flowOf(it.map())
                else flow { emit(webService.getPostById(id)) }
                    .onEach { postEntityDao.insert(it.mapToEntity()) }
                    .map { it.map() }
            }
    }
}


