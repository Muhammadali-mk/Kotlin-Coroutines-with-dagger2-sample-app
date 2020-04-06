package com.mk.recyclerviewtask.data.datasource.rest

import com.mk.recyclerviewtask.data.model.photo.Photo
import com.mk.recyclerviewtask.data.model.post.PostResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {

    @GET("/posts")
    suspend fun getPosts(): List<PostResponse>

    @GET("/posts/{id}")
    suspend fun getPostById(@Path(value = "id") postId: Int): PostResponse

    @GET("/photos")
    suspend fun getPhotos(): List<Photo>
}