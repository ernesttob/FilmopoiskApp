package com.example.movieapp.presentation.presentation_model.info

import java.io.Serializable

data class SpokenLanguagePresentation(
    val englishName: String,
    val iso6391: String,
    val name: String
): Serializable {
    companion object {
        val unknown = SpokenLanguagePresentation(
            englishName = "",
            name = "",
            iso6391 = ""
        )
    }
}