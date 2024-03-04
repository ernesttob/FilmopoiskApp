package com.example.movieapp.domain.domain_models.info

import java.io.Serializable

data class ProductionCompanyDomain(
    val id: Int,
    val logoPath: String,
    val name: String,
    val originCountry: String
) : Serializable