package com.mk.recyclerviewtask.data.mapper

import com.mk.recyclerviewtask.data.model.post.Post
import com.mk.recyclerviewtask.data.model.post.PostEntity

fun List<PostEntity>.map() =
    map { it.map() }

fun PostEntity.map() =
    Post(
        userId = id,
        id = userId,
        title = title,
        body = body
    )
