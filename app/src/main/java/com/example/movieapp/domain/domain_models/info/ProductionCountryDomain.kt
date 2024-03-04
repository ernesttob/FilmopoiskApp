package com.example.movieapp.domain.domain_models.info

import java.io.Serializable

data class ProductionCountryDomain(
    val iso31661: String,
    val name: String
): Serializable