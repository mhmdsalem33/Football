package com.sa.football.data.data_source.local.roomDB

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sa.football.domain.models.CompetitionModel


@Database( entities = [  CompetitionModel::class ] , version =  1  )
@TypeConverters(Converters::class)
abstract class CompetitionDatabase : RoomDatabase() {
    abstract fun competitionDao(): CompetitionDao
}