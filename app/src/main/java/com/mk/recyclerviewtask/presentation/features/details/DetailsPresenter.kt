package com.mk.recyclerviewtask.presentation.features.details

import com.mk.recyclerviewtask.domain.post.PostInteractor
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject
import kotlin.properties.Delegates

class DetailsPresenter @Inject constructor(
    private val interactor: PostInteractor
) : MvpPresenter<DetailsView>() {

    var postId:Int by Delegates.notNull()

    fun getPostById() {
        presenterScope.launch {
            interactor.getPostById(postId)
                .collect { viewState.onPostGet(it) }
        }
    }

}