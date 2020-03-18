package com.mk.recyclerviewtask.domain.post

import com.mk.recyclerviewtask.data.model.post.Post
import kotlinx.coroutines.flow.Flow

interface PostInteractor {

    fun getPosts(): Flow<Result<List<Post>>>

    fun getPostById(id: Int): Flow<Result<Post>>
}