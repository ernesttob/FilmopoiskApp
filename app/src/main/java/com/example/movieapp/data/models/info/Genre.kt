package com.example.movieapp.data.models.info

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Genre(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
):Serializable