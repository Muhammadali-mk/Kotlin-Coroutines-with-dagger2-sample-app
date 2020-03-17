package com.mk.recyclerviewtask.data.model.post

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class PostEntity(

    @PrimaryKey
    @ColumnInfo(name = "post_id")
    val id: Int,

    @ColumnInfo(name = "post_user_id")
    val userId: Int,

    @ColumnInfo(name = "post_title")
    val title: String,

    @ColumnInfo(name = "post_body")
    val body: String
)