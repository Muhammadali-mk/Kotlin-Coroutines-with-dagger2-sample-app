package com.mk.recyclerviewtask.presentation.features.photo

import com.mk.recyclerviewtask.domain.photo.PhotoInteractor
import com.mk.recyclerviewtask.utils.collect
import kotlinx.coroutines.launch
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

@InjectViewState
class PhotoPresenter @Inject constructor(
    private val interactor: PhotoInteractor
) : MvpPresenter<PhotoView>() {

    override fun onFirstViewAttach() =
        getPhotos()


    fun getPhotos() {
        presenterScope.launch {
            interactor.getPhotos()
                .collect(
                    onStart = {},
                    onSuccess = { viewState.displayPhotos(it) },
                    onFailure = {}
                )
        }
    }
}