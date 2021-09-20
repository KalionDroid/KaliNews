package com.kalinews.app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kalinews.app.models.Article

@Database(entities = [Article::class], version = 1)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    companion object {
        @Volatile
        private var instance: ArticleDatabase? = null

        operator fun invoke(context: Context) = synchronized(this) {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    ArticleDatabase::class.java,
                    "article_db.db"
                ).build()
            }
            instance
        }
    }
}