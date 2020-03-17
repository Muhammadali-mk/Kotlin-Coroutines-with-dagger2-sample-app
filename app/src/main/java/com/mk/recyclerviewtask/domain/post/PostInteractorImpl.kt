package com.mk.recyclerviewtask.domain.post

import com.mk.recyclerviewtask.data.model.post.Post
import com.mk.recyclerviewtask.data.model.post.PostResponse
import com.mk.recyclerviewtask.data.repository.post.PostRepository
import com.mk.recyclerviewtask.utils.flatMapResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostInteractorImpl @Inject constructor(
    private val repository: PostRepository
) : PostInteractor {

    @ExperimentalCoroutinesApi
    override fun getPosts(): Flow<Result<List<Post>>> {
        return repository.getPosts()
            .flatMapResult()
            .flowOn(Dispatchers.IO)
    }

    override fun getPostById(id: Int): Flow<Post> {
        return repository.getPostById(id)
    }
}