package com.kalinews.app.repository

import com.kalinews.app.api.RetrofitInstance
import com.kalinews.app.db.ArticleDatabase
import com.kalinews.app.models.Article

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNo: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNo)

    suspend fun searchNews(searchQuery: String, pageNo: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNo)

    suspend fun insert(article: Article) =
        db.getArticleDao().insert(article)

    fun getSavedArticle() = db.getArticleDao().getAllArticles()

    suspend fun delete(article: Article) =
        db.getArticleDao().deleteArticle(article)
}