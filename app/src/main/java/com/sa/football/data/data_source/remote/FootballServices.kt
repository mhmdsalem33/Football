package com.sa.football.data.data_source.remote

import com.sa.football.data.entity.CompetitionsDTO
import retrofit2.Response
import retrofit2.http.GET

interface FootballServices {

    @GET("competitions")
    suspend fun getCompetitions() : Response<CompetitionsDTO>

}