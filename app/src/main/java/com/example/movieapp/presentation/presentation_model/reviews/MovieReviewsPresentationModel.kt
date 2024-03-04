package com.example.movieapp.presentation.presentation_model.reviews

import com.example.movieapp.data.models.reviews.ResultModel
import java.io.Serializable


data class MovieReviewsPresentationModel(
    val id: Int,
    val page: Int,
    val results: List<ResultModel>,
    val totalPages: Int,
    val totalResults: Int
) : Serializable {
    companion object {
        val unknown = MovieReviewsPresentationModel(
            id = 0,
            page = 0,
            results = listOf(),
            totalPages = 0,
            totalResults = 0
        )
    }
}