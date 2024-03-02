package com.sa.football.data.entity


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName


@Keep
data class AreaDTO(
    @SerializedName("code")
    val code: String = "",
    @SerializedName("flag")
    val flag: String = "",
    @SerializedName("id")
    val id: Int = 0 ,
    @SerializedName("name")
    val name: String = ""
)