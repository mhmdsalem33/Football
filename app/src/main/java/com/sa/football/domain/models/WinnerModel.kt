package com.sa.football.domain.models

import androidx.annotation.Keep


@Keep
data class WinnerModel(
    val address: String = "",
    val clubColors: String = "",
    val crest: String = "",
    val founded: Int = 0,
    val id: Int = 0,
    val lastUpdated: String = "",
    val name: String = "",
    val shortName: String = "",
    val tla: String = "",
    val venue: String = "",
    val website: String = ""
)