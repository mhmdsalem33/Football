package com.sa.football.data.entity


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName


@Keep
data class CompetitionDTO(
    @SerializedName("area")
    val area: AreaDTO?,
    @SerializedName("code")
    val code: String?,
    @SerializedName("currentSeason")
    val currentSeason: CurrentSeasonDTO ?,
    @SerializedName("emblem")
    val emblem: String ? ,
    @SerializedName("id")
    val id: Int ? ,
    @SerializedName("lastUpdated")
    val lastUpdated: String? ,
    @SerializedName("name")
    val name: String ?,
    @SerializedName("numberOfAvailableSeasons")
    val numberOfAvailableSeasons: Int ? ,
    @SerializedName("plan")
    val plan: String ?,
    @SerializedName("type")
    val type: String ?
)