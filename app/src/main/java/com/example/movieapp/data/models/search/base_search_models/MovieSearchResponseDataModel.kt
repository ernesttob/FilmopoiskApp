package com.example.movieapp.data.models.search.base_search_models

import java.io.Serializable

data class MovieSearchResponseDataModel(
    val result: List<MovieSearchDataModel>
) : Serializable {
    companion object {
        val unknown = MovieSearchResponseDataModel(
            result = emptyList()
        )
    }
}