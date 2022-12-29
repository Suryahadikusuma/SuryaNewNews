package com.suryahadi.newsapp.repository

import com.suryahadi.newsapp.data.local.ArticleDao
import com.suryahadi.newsapp.data.model.Article
import com.suryahadi.newsapp.data.model.NewsResponse
import com.suryahadi.newsapp.data.remote.NewsApi
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton
// untuk mengambil article dan menyimpanya secara offline.
@Singleton
class NewsRepository @Inject constructor(
    private val newsApi: NewsApi,
    private val articleDao: ArticleDao
) {
    // untuk mengambil article
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int): Response<NewsResponse> {
        return newsApi.getBreakingNews(countryCode,pageNumber)
    }
    // untuk pencarian article
    suspend fun searchNews(searchQuery: String, pageNumber: Int): Response<NewsResponse>{
        return newsApi.searchForNews(searchQuery, pageNumber)
    }
    // untuk mengambil semua article
    fun getAllArticles() = articleDao.getArticles()
    // untuk memasukan article ke database
    suspend fun insertArticle(article: Article) = articleDao.insert(article)
    // Untuk menghapus article dalam database
    suspend fun deleteArticle(article: Article) = articleDao.delete(article)
    // untuk menghpus semua article dalam database
    suspend fun deleteAllArticles() = articleDao.deleteAllArticles()
}