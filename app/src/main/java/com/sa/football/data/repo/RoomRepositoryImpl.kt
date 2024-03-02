package com.sa.football.data.repo

import com.sa.football.data.data_source.local.roomDB.CompetitionDao
import com.sa.football.domain.models.CompetitionModel
import com.sa.football.domain.repositories.RoomRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RoomRepositoryImpl @Inject constructor(private val dao: CompetitionDao) : RoomRepository{
    override suspend fun upsertCompetition ( competitions : List<CompetitionModel>) =  dao.upsertCompetition(competitions)
    override fun getSavedCompetition(): Flow<List<CompetitionModel>> = dao.getSavedCompetition()
}