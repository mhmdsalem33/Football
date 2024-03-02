package com.sa.football.data.data_source.local.roomDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sa.football.domain.models.CompetitionModel
import kotlinx.coroutines.flow.Flow


@Dao
interface CompetitionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertCompetition(   competitions  : List<CompetitionModel>)

    @Query("SELECT * FROM competitionInformation")
    fun getSavedCompetition() : Flow<List<CompetitionModel>>

    @Query("DELETE FROM competitionInformation")
    suspend fun deleteAllCompetitions()




}