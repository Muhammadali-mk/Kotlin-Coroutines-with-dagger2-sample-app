package com.mk.recyclerviewtask.domain.post.details

import com.mk.recyclerviewtask.data.model.post.Post
import kotlinx.coroutines.flow.Flow

interface DetailsInteractor {

    fun getPostById(id: Int): Flow<Result<Post>>
}