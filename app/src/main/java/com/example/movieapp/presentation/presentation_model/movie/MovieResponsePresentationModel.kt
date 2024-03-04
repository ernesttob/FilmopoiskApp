package com.example.movieapp.presentation.presentation_model.movie

import java.io.Serializable

data class MovieResponsePresentationModel(
    val results: List<MoviePresentationModel>
) : Serializable {
    companion object {
        val unknown = MovieResponsePresentationModel(
            results = emptyList()
        )
    }
}
