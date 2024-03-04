package com.example.movieapp.presentation.presentation_model.info

import java.io.Serializable

data class ProductionCompanyPresentation(
    val id: Int,
    val logoPath: String,
    val name: String,
    val originCountry: String
) : Serializable {
    companion object {
        val unknown = ProductionCompanyPresentation(
            id = 0,
            logoPath = "",
            name = "",
            originCountry = ""
        )
    }
}