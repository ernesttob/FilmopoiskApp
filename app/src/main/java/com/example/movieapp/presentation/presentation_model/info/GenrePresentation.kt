package com.example.movieapp.presentation.presentation_model.info

import java.io.Serializable

data class GenrePresentation(
    val id: Int,
    val name: String
): Serializable {
    companion object {
        val unknown = GenrePresentation(
            id = 0,
            name = ""
        )
    }
}