package com.example.movieapp.domain.domain_models.reviews

import com.example.movieapp.data.models.reviews.AuthorDetails
import java.io.Serializable


data class ResultDomain(
    val author: String,
    val authorDetails: AuthorDetails,
    val content: String,
    val createdAt: String,
    val id: String,
    val updatedAt: String,
    val url: String
):Serializable