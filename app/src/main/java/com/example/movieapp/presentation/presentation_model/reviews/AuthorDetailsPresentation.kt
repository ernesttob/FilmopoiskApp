package com.example.movieapp.presentation.presentation_model.reviews

import java.io.Serializable

data class AuthorDetailsPresentation(
    val avatarPath: String,
    val name: String,
    val rating: Double,
    val username: String
): Serializable