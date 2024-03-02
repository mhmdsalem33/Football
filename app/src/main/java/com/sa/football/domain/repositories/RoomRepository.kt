package com.sa.football.domain.repositories

import com.sa.football.domain.models.CompetitionModel
import kotlinx.coroutines.flow.Flow

interface RoomRepository {
    suspend fun upsertCompetition(   competitions  : List<CompetitionModel>)
    fun getSavedCompetition() : Flow<List<CompetitionModel>>
}