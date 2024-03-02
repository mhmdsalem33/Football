package com.sa.football.data.entity


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName


@Keep
data class CurrentSeasonDTO(
    @SerializedName("currentMatchday")
    val currentMatchday: Int = 0,
    @SerializedName("endDate")
    val endDate: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("startDate")
    val startDate: String = "",
    @SerializedName("winner")
    val winner: WinnerDTO = WinnerDTO()
)