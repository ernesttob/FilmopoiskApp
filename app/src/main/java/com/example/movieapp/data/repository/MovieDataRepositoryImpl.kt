package com.example.movieapp.data.repository

import com.example.movieapp.data.base.BaseDataSource
import com.example.movieapp.data.base.models.ResultStatus
import com.example.movieapp.data.mappers.info.toDomain
import com.example.movieapp.data.mappers.movie.toDomainModel
import com.example.movieapp.data.mappers.reviews.toDomain
import com.example.movieapp.data.mappers.search.toDomain
import com.example.movieapp.domain.domain_models.reviews.MovieReviewsDomainModel
import com.example.movieapp.data.remote.MovieService
import com.example.movieapp.domain.domain_models.info.MovieInfoModelDomain
import com.example.movieapp.domain.domain_models.models.main.ResultsMovieDomainModel
import com.example.movieapp.domain.domain_models.search.SearchMovieDomainModel
import com.example.movieapp.domain.repository.MovieListDataRepository

class MovieDataRepositoryImpl(
    private val service: MovieService
) : MovieListDataRepository, BaseDataSource() {

    override suspend fun getTopRatedMovieList(): ResultStatus<List<ResultsMovieDomainModel>> {
        val response = invokeResponseRequest {
            service.getTopRatedMovieList()
        }
        return ResultStatus(
            status = response.status,
            data = response.data?.result?.map { it.toDomainModel() },
            errorThrowable = response.errorThrowable
        )
    }

    override suspend fun getUpcomingMovieList(): ResultStatus<List<ResultsMovieDomainModel>> {
        val response = invokeResponseRequest {
            service.getUpcomingMovieList()
        }
        return ResultStatus(
            status = response.status,
            data = response.data?.result?.map { it.toDomainModel() },
            errorThrowable = response.errorThrowable
        )
    }

    override suspend fun getPopularMovieList(): ResultStatus<List<ResultsMovieDomainModel>> {
        val response = invokeResponseRequest {
            service.getPopularMovieList()
        }
        return ResultStatus(
            status = response.status,
            data = response.data?.result?.map { it.toDomainModel() },
            errorThrowable = response.errorThrowable
        )
    }

    override suspend fun getNowPlayingMovieList(): ResultStatus<List<ResultsMovieDomainModel>> {
        val response = invokeResponseRequest {
            service.getNowPlayingMovieList()
        }
        return ResultStatus(
            status = response.status,
            data = response.data?.result?.map { it.toDomainModel() },
            errorThrowable = response.errorThrowable
        )
    }

    override suspend fun getMovieInfoList(movieId: Int): ResultStatus<MovieInfoModelDomain> {
        val response = invokeResponseRequest {
            service.getMovieInfo(
                movieId = movieId
            )
        }
        return ResultStatus(
            status = response.status,
            data = response.data?.toDomain(),
            errorThrowable = response.errorThrowable,

        )
    }

    override suspend fun getMovieReviews(movieId: Int): ResultStatus<MovieReviewsDomainModel> {
        val response = invokeResponseRequest {
            service.getMovieReviews(
                movieId
            )
        }
        return ResultStatus(
            status = response.status,
            data = response.data?.toDomain(),
            errorThrowable = response.errorThrowable
        )
    }

    override suspend fun getMovieSearch(query: String): ResultStatus<List<SearchMovieDomainModel>> {
        val response = invokeResponseRequest {
            service.getKinofySearch(searchQuery = query)
        }
        return ResultStatus(
            status = response.status,
            data = response.data?.results?.map { it.toDomain() },
            errorThrowable = response.errorThrowable
        )
    }
}