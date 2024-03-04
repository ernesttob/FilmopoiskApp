package com.example.movieapp.presentation.presentation_model.info

import java.io.Serializable

data class BelongsToCollectionPresentation(
    val backdropPath: String,
    val id: Int,
    val name: String,
    val posterPath: String
): Serializable {
    companion object {
        val unknown = BelongsToCollectionPresentation(
            backdropPath = "",
            id = 0,
            name = "",
            posterPath = ""
        )
    }
}