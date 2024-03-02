package com.sa.football.data.entity


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.sa.football.domain.models.AreaModel
import com.sa.football.domain.models.CompetitionModel
import com.sa.football.domain.models.CompetitionsModel
import com.sa.football.domain.models.CurrentSeasonModel
import com.sa.football.domain.models.WinnerModel

@Keep
data class CompetitionsDTO(
    @SerializedName("competitions")
    val competitions: List<CompetitionDTO>  = emptyList(),
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("filters")
    val filters: FiltersDTO = FiltersDTO()
)



fun CompetitionsDTO.toDomain() :CompetitionsModel{
    return CompetitionsModel(
        competitions = this.competitions.map { it.toDomain() },
    )
}


fun CompetitionDTO.toDomain() : CompetitionModel{
    return CompetitionModel(
        name    =  this.name ?: "",
        area    =  this.area.toDomain(),
        id      =  this.id ?: 0,
        emblem  =  this.emblem ?: "",
        type = this.type ?: "",
        lastUpdated = this.lastUpdated ?: "",
        currentSeason = this.currentSeason.toDomain(),
        numberOfAvailableSeasons =  this.numberOfAvailableSeasons ?: 0,
    )
}

fun AreaDTO?.toDomain() : AreaModel{
    return AreaModel(
        name = this?.name ?: ""
    )
}

fun CurrentSeasonDTO?.toDomain() : CurrentSeasonModel{
    return CurrentSeasonModel(
        startDate = this?.startDate ?: "",
        endDate = this?.endDate ?: "",
        id =  this?.id ?: 0,
        currentMatchday =  this?.currentMatchday ?: 0,
        winner = this?.winner.toDomain()
    )
}

fun WinnerDTO?.toDomain() : WinnerModel {
    return WinnerModel(
        id = this?.id ?: 0,
        name =  this?.name ?: "",
        shortName =  this?.shortName ?: ""
    )
}


