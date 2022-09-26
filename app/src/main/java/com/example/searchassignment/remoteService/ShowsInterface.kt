package com.example.searchassignment.remoteService

import com.example.searchassignment.model.ShowsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


// https://api.tvmaze.com/ = BASE
// singlesearch/shows = SHOWLIST
// ?q=girls = QUERY

interface ShowsInterface {

    @GET("singlesearch/shows")
    suspend fun getShowDetails(@Query("q") showName: String): Response<ShowsModel>
}