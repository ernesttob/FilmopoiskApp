package com.example.movieapp.domain.domain_models.info

import java.io.Serializable

data class SpokenLanguageDomain(
    val englishName: String,
    val iso6391: String,
    val name: String
) : Serializable