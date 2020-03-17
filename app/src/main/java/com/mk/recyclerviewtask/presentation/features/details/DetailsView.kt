package com.mk.recyclerviewtask.presentation.features.details

import com.mk.recyclerviewtask.data.model.post.Post
import moxy.MvpView

interface DetailsView : MvpView {

    fun onPostGet(post: Post)
}