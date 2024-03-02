package com.sa.football.domain.models

import androidx.annotation.Keep

@Keep
data class CompetitionsModel(
    val competitions: List<CompetitionModel> = emptyList(),
)