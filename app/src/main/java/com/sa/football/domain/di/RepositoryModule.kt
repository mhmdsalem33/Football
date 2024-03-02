package com.sa.football.domain.di

import com.sa.football.data.data_source.remote.FootballServices
import com.sa.football.data.repo.MainRepositoryImpl
import com.sa.football.domain.repositories.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {


    @Singleton
    @Provides
    fun provideMainRepository( footballServices: FootballServices ) : MainRepository = MainRepositoryImpl(footballServices)





}