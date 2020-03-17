package com.mk.recyclerviewtask.data.repository.photo

import com.mk.recyclerviewtask.data.datasource.rest.WebService
import com.mk.recyclerviewtask.data.model.Photo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val webService: WebService
) : PhotoRepository {

    @ExperimentalCoroutinesApi
    override fun getPhotos(): Flow<List<Photo>> {
        return flow { emit(webService.getPhotos()) }
    }
}