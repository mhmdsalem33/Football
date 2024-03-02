package com.sa.football.domain.models

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity( tableName  = "competitionInformation")
data class CompetitionModel(
    val area: AreaModel          = AreaModel(),
    val emblem: String           = "",
    @PrimaryKey
    val id             : Int      = 0,
    val name           : String   = "",
    val currentSeason  : CurrentSeasonModel = CurrentSeasonModel() ,
    val lastUpdated    : String   = "",
    val numberOfAvailableSeasons: Int = 0,
    val plan           : String    = "",
    val type           : String    = ""

)