package com.sa.football.domain.usecase

import androidx.room.withTransaction
import com.sa.football.data.utils.NetworkUtils
import com.sa.football.data.core.Resource
import com.sa.football.data.data_source.local.roomDB.CompetitionDatabase
import com.sa.football.data.entity.toDomain
import com.sa.football.data.core.networkBoundResource
import com.sa.football.domain.models.CompetitionModel
import com.sa.football.domain.repositories.MainRepository
import com.sa.football.domain.repositories.RoomRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class GetCompetitionsUseCase @Inject constructor(
    private val mainRepository: MainRepository,
    private val roomRepository: RoomRepository,
    private val db: CompetitionDatabase,
    private val checkNetworkStatus: NetworkUtils

) {
    private val competitionDao = db.competitionDao()

    operator fun invoke(): Flow<Resource<List<CompetitionModel>>> {
        return networkBoundResource(
            checkNetworkStatus.isNetworkAvailable(),
            query = {
                roomRepository.getSavedCompetition()
            },
            fetch = {
                mainRepository.getCompetitions()
            },
            saveFetchResult = { response ->
                val competitionsList = response.body()?.toDomain()?.competitions ?: emptyList()
                db.withTransaction {
                    competitionDao.deleteAllCompetitions()
                    competitionDao.upsertCompetition(competitionsList)
                }
            },
            getCachedData = {
                roomRepository.getSavedCompetition().firstOrNull() ?: emptyList()
            },
            shouldFetch = { _, hasInternetConnection -> hasInternetConnection }
        )
    }
}
