package com.mk.recyclerviewtask.data.repository.post

import com.mk.recyclerviewtask.data.model.post.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    fun getPosts(): Flow<List<Post>>

    fun getPostById(id: Int): Flow<Post>
}