package com.sa.football.data.di

import android.app.Application
import androidx.room.Room
import com.sa.football.data.data_source.local.roomDB.CompetitionDao
import com.sa.football.data.data_source.local.roomDB.CompetitionDatabase
import com.sa.football.data.repo.RoomRepositoryImpl
import com.sa.football.domain.repositories.RoomRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase( app  : Application ) : CompetitionDatabase =
        Room.databaseBuilder( app , CompetitionDatabase::class.java  , "competition_database.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()


    @Singleton
    @Provides
    fun provideRoomRepository(  roomRepositoryImpl: RoomRepositoryImpl ): RoomRepository {
        return roomRepositoryImpl
    }

    @Singleton
    @Provides
    fun provideCompetitionDao( database: CompetitionDatabase ): CompetitionDao {
        return database.competitionDao()
    }

}

