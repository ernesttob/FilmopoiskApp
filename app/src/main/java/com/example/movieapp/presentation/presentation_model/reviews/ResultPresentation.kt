package com.example.movieapp.presentation.presentation_model.reviews

import com.example.movieapp.data.models.reviews.AuthorDetails
import java.io.Serializable


data class ResultPresentation(
    val author: String,
    val authorDetails: AuthorDetails,
    val content: String,
    val createdAt: String,
    val id: String,
    val updatedAt: String,
    val url: String
):Serializable