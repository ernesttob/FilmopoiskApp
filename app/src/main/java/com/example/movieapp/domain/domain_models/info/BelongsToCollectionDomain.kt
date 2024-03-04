package com.example.movieapp.domain.domain_models.info

import java.io.Serializable

data class BelongsToCollectionDomain(
    val backdropPath: String,
    val id: Int,
    val name: String,
    val posterPath: String
): Serializable