package com.mk.recyclerviewtask.data.datasource.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mk.recyclerviewtask.data.model.post.PostEntity

@Dao
interface PostEntityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(list: List<PostEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: PostEntity)

    @Query("SELECT * FROM posts")
    fun getPosts(): List<PostEntity>

    @Query("SELECT * FROM posts WHERE post_user_id = :id")
    fun getPostById(id: Int): PostEntity?
}