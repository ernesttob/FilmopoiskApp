package com.example.movieapp.domain.domain_models.reviews

import java.io.Serializable

data class AuthorDetailsDomain(
    val avatarPath: String,
    val name: String,
    val rating: Double,
    val username: String
): Serializable