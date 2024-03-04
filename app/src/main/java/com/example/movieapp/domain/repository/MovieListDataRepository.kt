package com.example.movieapp.domain.repository

import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.domain.domain_models.reviews.MovieReviewsDomainModel
import com.example.movieapp.domain.domain_models.info.MovieInfoModelDomain
import com.example.movieapp.domain.domain_models.models.main.ResultsMovieDomainModel
import com.example.movieapp.domain.domain_models.search.SearchMovieDomainModel

interface MovieListDataRepository {

    suspend fun getTopRatedMovieList(): ResultStatus<List<ResultsMovieDomainModel>>

    suspend fun getUpcomingMovieList(): ResultStatus<List<ResultsMovieDomainModel>>

    suspend fun getPopularMovieList(): ResultStatus<List<ResultsMovieDomainModel>>

    suspend fun getNowPlayingMovieList(): ResultStatus<List<ResultsMovieDomainModel>>

    suspend fun getMovieInfoList(movieId:Int): ResultStatus<MovieInfoModelDomain>

    suspend fun getMovieReviews(movieId: Int): ResultStatus<MovieReviewsDomainModel>

    suspend fun getMovieSearch(query:String): ResultStatus<List<SearchMovieDomainModel>>

}