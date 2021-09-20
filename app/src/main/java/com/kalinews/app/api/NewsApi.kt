package com.kalinews.app.api

import com.kalinews.app.models.NewsResponse
import com.kalinews.app.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    suspend fun getBreakingNews(
        @Query("country") country: String = "us",
        @Query("page") pageNo: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET("everything")
    suspend fun searchForNews(
        @Query("q") searchQuery: String = "us",
        @Query("page") pageNo: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<NewsResponse>

}