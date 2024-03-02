package com.sa.football.data.repo

import com.sa.football.data.data_source.remote.FootballServices
import com.sa.football.data.entity.CompetitionsDTO
import com.sa.football.domain.repositories.MainRepository
import retrofit2.Response

class MainRepositoryImpl(private val footballServices: FootballServices) : MainRepository {
    override suspend fun getCompetitions(): Response<CompetitionsDTO>  =  footballServices.getCompetitions()
}