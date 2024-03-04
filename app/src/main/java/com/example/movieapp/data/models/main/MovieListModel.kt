package com.example.movieapp.data.models.main

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieListModel(
    @SerializedName("results")
    val result: List<ResultsMovieModel>
): Serializable {
    companion object {
        val unknown = MovieListModel(
            result = emptyList()
        )
    }
}