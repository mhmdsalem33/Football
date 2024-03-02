package com.sa.football.data.entity


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName


@Keep
data class WinnerDTO(
    @SerializedName("address")
    val address: String = "",
    @SerializedName("clubColors")
    val clubColors: String = "",
    @SerializedName("crest")
    val crest: String = "",
    @SerializedName("founded")
    val founded: Int = 0,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("lastUpdated")
    val lastUpdated: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("shortName")
    val shortName: String = "",
    @SerializedName("tla")
    val tla: String = "",
    @SerializedName("venue")
    val venue: String = "",
    @SerializedName("website")
    val website: String = ""
)