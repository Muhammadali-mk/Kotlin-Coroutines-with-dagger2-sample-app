package com.mk.recyclerviewtask.data.datasource.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mk.recyclerviewtask.data.model.post.PostEntity

@Database(entities = [PostEntity::class], exportSchema = false, version = 1)
 abstract class PostDatabase : RoomDatabase() {

    internal abstract fun postEntityDao(): PostEntityDao

    companion object {
        private const val DATABASE_NAME: String = "post_database"

        @Volatile
        private var database: PostDatabase? = null

        fun getPostDatabase(context: Context): PostDatabase {
            Log.wtf("my_log", "create database context = $context")
            Log.wtf("my_log", "create database database = $database")
            if (database == null) {
                synchronized(PostDatabase::class) {
                    database = Room.databaseBuilder(
                        context,
                        PostDatabase::class.java,
                        DATABASE_NAME
                    ).also {
                        Log.wtf("my_log", "create database builder = ${it.toString()}")
                    }.build().also {
                        Log.wtf("my_log", "create database after build = $it")
                    }
                }
            }
            return checkNotNull(database)
        }
    }
}