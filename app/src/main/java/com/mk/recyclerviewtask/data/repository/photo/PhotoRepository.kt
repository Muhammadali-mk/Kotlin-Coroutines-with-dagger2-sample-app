package com.mk.recyclerviewtask.data.repository.photo

import com.mk.recyclerviewtask.data.model.photo.Photo
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {

    fun getPhotos(): Flow<List<Photo>>
}