package com.mk.recyclerviewtask.presentation.features.post

import com.mk.recyclerviewtask.domain.post.PostInteractor
import com.mk.recyclerviewtask.utils.collect
import kotlinx.coroutines.launch
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

@InjectViewState
class PostPresenter @Inject constructor(
    private val interactor: PostInteractor
) : MvpPresenter<PostView>() {

    override fun onFirstViewAttach() =
        getPosts()

    fun getPosts() {
        presenterScope.launch {
            interactor.getPosts()
                .collect(
                    onStart = {viewState.onLoadingPost()},
                    onSuccess = { viewState.displayPosts(it) },
                    onFailure = {viewState.onFailurePost(it)}
                )
        }
    }
}