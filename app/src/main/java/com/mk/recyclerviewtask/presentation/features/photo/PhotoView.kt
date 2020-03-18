package com.mk.recyclerviewtask.presentation.features.photo

import com.mk.recyclerviewtask.data.model.photo.Photo
import moxy.MvpView

interface PhotoView : MvpView {

    fun onLoadingPhotos()

    fun displayPhotos(photo: List<Photo>)

    fun onFailurePhotos(throwable: Throwable)

}