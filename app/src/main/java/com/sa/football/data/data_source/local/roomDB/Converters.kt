package com.sa.football.data.data_source.local.roomDB

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sa.football.domain.models.AreaModel
import com.sa.football.domain.models.CurrentSeasonModel
import com.sa.football.domain.models.WinnerModel

object Converters {
    @TypeConverter
    @JvmStatic
    fun fromAreaModel(value: AreaModel): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    @JvmStatic
    fun toAreaModel(value: String?): AreaModel? {
        return value?.let {
            val type = object : TypeToken<AreaModel>() {}.type
            Gson().fromJson(value, type)
        }
    }

    @TypeConverter
    @JvmStatic
    fun fromCurrentSeasonModel(value: CurrentSeasonModel): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    @JvmStatic
    fun toCurrentSeasonModel(value: String?): CurrentSeasonModel? {
        return value?.let {
            val type = object : TypeToken<CurrentSeasonModel>() {}.type
            Gson().fromJson(value, type)
        }
    }

    @TypeConverter
    @JvmStatic
    fun fromWinnerModel(value: WinnerModel): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    @JvmStatic
    fun toWinnerModel(value: String?): WinnerModel? {
        return value?.let {
            val type = object : TypeToken<WinnerModel>() {}.type
            Gson().fromJson(value, type)
        }
    }
}

