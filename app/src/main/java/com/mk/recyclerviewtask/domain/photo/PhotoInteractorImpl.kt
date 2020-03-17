package com.mk.recyclerviewtask.domain.photo

import com.mk.recyclerviewtask.data.model.Photo
import com.mk.recyclerviewtask.data.repository.photo.PhotoRepository
import com.mk.recyclerviewtask.utils.flatMapResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PhotoInteractorImpl @Inject constructor(
    private val repository: PhotoRepository
) : PhotoInteractor {

    @ExperimentalCoroutinesApi
    override fun getPhotos(): Flow<Result<List<Photo>>> {
        return repository.getPhotos()
            .flatMapResult()
            .flowOn(Dispatchers.IO)
    }
}