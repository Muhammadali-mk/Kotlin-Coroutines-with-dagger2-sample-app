package com.mk.recyclerviewtask.data.model.post

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)