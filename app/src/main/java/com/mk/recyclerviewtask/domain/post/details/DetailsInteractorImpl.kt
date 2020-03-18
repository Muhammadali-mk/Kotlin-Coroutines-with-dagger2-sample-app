package com.mk.recyclerviewtask.domain.post.details

import com.mk.recyclerviewtask.data.model.post.Post
import com.mk.recyclerviewtask.data.model.post.PostResponse
import com.mk.recyclerviewtask.data.repository.details.DetailsRepository
import com.mk.recyclerviewtask.data.repository.post.PostRepository
import com.mk.recyclerviewtask.utils.flatMapResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DetailsInteractorImpl @Inject constructor(
    private val repository: DetailsRepository
) : DetailsInteractor {

    @ExperimentalCoroutinesApi
    override fun getPostById(id: Int): Flow<Result<Post>> {
        return repository.getPostById(id)
            .flatMapResult()
            .flowOn(Dispatchers.IO)
    }
}