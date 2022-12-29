package com.suryahadi.newsapp.di

import android.app.Application
import androidx.room.Room
import com.suryahadi.newsapp.data.local.ArticleDao
import com.suryahadi.newsapp.data.local.ArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
// untuk memasukan data pada database menggunakan dagger.
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application, callback: ArticleDatabase.Callback): ArticleDatabase{
        return Room.databaseBuilder(application, ArticleDatabase::class.java, "news_database")
            .fallbackToDestructiveMigration()
            .addCallback(callback)
            .build()
    }

    @Provides
    fun provideArticleDao(db: ArticleDatabase): ArticleDao{
        return db.getArticleDao()
    }
}