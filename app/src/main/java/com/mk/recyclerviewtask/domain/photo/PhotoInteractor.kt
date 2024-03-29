package com.mk.recyclerviewtask.domain.photo

import com.mk.recyclerviewtask.data.model.photo.Photo
import kotlinx.coroutines.flow.Flow

interface PhotoInteractor {

    fun getPhotos(): Flow<Result<List<Photo>>>
}