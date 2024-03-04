package com.example.movieapp.di

import com.example.movieapp.domain.repository.MovieListDataRepository
import com.example.movieapp.domain.use_cases.movie_info.DefaultMovieInfo
import com.example.movieapp.domain.use_cases.movie_info.GetMovieInfo
import com.example.movieapp.domain.use_cases.now_playing.DefaultNowPlayingMovieList
import com.example.movieapp.domain.use_cases.now_playing.GetNowPlayingMovieList
import com.example.movieapp.domain.use_cases.popular.DefaultPopularMovieList
import com.example.movieapp.domain.use_cases.popular.GetPopularMovieList
import com.example.movieapp.domain.use_cases.top_rated.DefaultTopRatedMovieList
import com.example.movieapp.domain.use_cases.top_rated.GetTopRatedMovieList
import com.example.movieapp.domain.use_cases.upcoming.DefaultUpcomingMovieList
import com.example.movieapp.domain.use_cases.upcoming.GetUpcomingMovieList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun providesGetCurrentMoviePopularUseCase(
        repository: MovieListDataRepository
    ): GetPopularMovieList = DefaultPopularMovieList(
        repository = repository
    )

    @Provides
    fun providesGetCurrentMovieNowPlayingUseCase(
        repository: MovieListDataRepository
    ): GetNowPlayingMovieList = DefaultNowPlayingMovieList(
        repository = repository
    )

    @Provides
    fun providesGetCurrentMovieUpcomingUseCase(
        repository: MovieListDataRepository
    ): GetUpcomingMovieList = DefaultUpcomingMovieList(
        repository = repository
    )

    @Provides
    fun providesGetCurrentMovieTopRatedUseCase(
        repository: MovieListDataRepository
    ): GetTopRatedMovieList = DefaultTopRatedMovieList(
        repository = repository
    )

    @Provides
    fun providesGetKinofyInfoUseCase(
        repository: MovieListDataRepository
    ): GetMovieInfo = DefaultMovieInfo(
        repository = repository
    )

}