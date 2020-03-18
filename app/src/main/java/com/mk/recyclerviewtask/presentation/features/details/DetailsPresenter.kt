package com.mk.recyclerviewtask.presentation.features.details

import com.mk.recyclerviewtask.domain.post.details.DetailsInteractor
import com.mk.recyclerviewtask.utils.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject
import kotlin.properties.Delegates

class DetailsPresenter @Inject constructor(
    private val detailsInteractor: DetailsInteractor
) : MvpPresenter<DetailsView>() {
    var id: Int by Delegates.notNull()

    override fun onFirstViewAttach() =
        getPostById()

    @Suppress("EXPERIMENTAL_API_USAGE")
    fun getPostById() {
        presenterScope.launch {
            detailsInteractor.getPostById(id)
                .onStart { viewState.onLoadingPost() }
                .collect(
                    onStart = { viewState.onLoadingPost() },
                    onSuccess = { viewState.onSuccessPost(it) },
                    onFailure = { viewState.onFailurePost(it) }
                )
        }
    }

}