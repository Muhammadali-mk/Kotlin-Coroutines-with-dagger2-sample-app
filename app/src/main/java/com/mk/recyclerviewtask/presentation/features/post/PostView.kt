package com.mk.recyclerviewtask.presentation.features.post

import com.mk.recyclerviewtask.data.model.post.Post
import moxy.MvpView

interface PostView : MvpView {

    fun displayPosts(post: List<Post>)

    fun onFailurePost(throwable: Throwable)

    fun onLoadingPost()
}