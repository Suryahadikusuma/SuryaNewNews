package com.suryahadi.newsapp.data.model
/**
 * untuk memprentasikan entity dari NewsResponse.
 */
data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)