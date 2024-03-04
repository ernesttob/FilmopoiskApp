package com.example.movieapp.presentation.presentation_model.info

import java.io.Serializable

data class ProductionCountryPresentation(
    val iso31661: String,
    val name: String
): Serializable {
    companion object {
        val unknown = ProductionCountryPresentation(
            name = "",
            iso31661 = ""
        )
    }
}