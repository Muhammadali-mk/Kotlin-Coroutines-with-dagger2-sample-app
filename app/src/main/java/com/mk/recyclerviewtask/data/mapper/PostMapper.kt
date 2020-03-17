package com.mk.recyclerviewtask.data.mapper

import com.mk.recyclerviewtask.data.model.post.Post
import com.mk.recyclerviewtask.data.model.post.PostEntity
import com.mk.recyclerviewtask.data.model.post.PostResponse

fun List<PostResponse>.mapToEntities() =
    map { it.mapToEntity() }

fun List<PostResponse>.map() =
    map { it.map() }

fun PostResponse.map() =
    Post(
        userId = id,
        id = userId,
        title = title,
        body = body
    )

fun PostResponse.mapToEntity() =
    PostEntity(
        id = id,
        userId = userId,
        title = title,
        body = body
    )