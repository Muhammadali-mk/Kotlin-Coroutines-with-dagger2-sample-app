package com.mk.recyclerviewtask.presentation.features.photo

import com.mk.recyclerviewtask.data.model.Photo
import moxy.MvpView

interface PhotoView:MvpView {

    fun displayPhotos(photo: List<Photo>)
}