package com.sa.football.domain.models

import androidx.annotation.Keep

@Keep
data class CurrentSeasonModel(
    val currentMatchday: Int = 0,
    val endDate: String = "",
    val id: Int = 0,
    val startDate: String = "",
    val winner: WinnerModel = WinnerModel()
)