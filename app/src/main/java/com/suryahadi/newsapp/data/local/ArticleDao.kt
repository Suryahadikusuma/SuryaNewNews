package com.suryahadi.newsapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.suryahadi.newsapp.data.model.Article
/**
 * method utnuk mengakses fungsi database.
 */
@Dao
interface ArticleDao {
    // untuk memanggil data yang ada pada article_table
    @Query("SELECT * FROM article_table")
    fun getArticles() : LiveData<List<Article>>
    // untuk memasukan data ke article_table
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article) : Long
    // untuk menghapus data dari article_table
    @Delete
    suspend fun delete(article: Article)
    // untuk menghapus semua data dari article_table
    @Query("DELETE FROM article_table")
    suspend fun deleteAllArticles()
}