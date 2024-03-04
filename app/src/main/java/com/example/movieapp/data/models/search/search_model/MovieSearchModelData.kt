package com.example.movieapp.data.models.search.search_model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieSearchModelData(
    @SerializedName("results")
    val results: List<MovieSearchModel>
) : Serializable {
    companion object {
        val unknown = MovieSearchModelData(
            results = emptyList()
        )
    }
}
