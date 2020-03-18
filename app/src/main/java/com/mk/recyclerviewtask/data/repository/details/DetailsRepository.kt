package com.mk.recyclerviewtask.data.repository.details

import com.mk.recyclerviewtask.data.model.post.Post
import kotlinx.coroutines.flow.Flow

interface DetailsRepository {

    fun getPostById(id: Int): Flow<Post>
}