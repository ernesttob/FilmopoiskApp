package com.example.movieapp.data.models.reviews

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class AuthorDetails(
    @SerializedName("avatar_path")
    val avatarPath: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("username")
    val username: String
): Serializable