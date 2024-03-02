package com.sa.football.domain.repositories

import com.sa.football.data.entity.CompetitionsDTO
import retrofit2.Response

interface MainRepository {
    suspend fun getCompetitions() : Response<CompetitionsDTO>
}