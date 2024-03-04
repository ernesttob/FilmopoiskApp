package com.example.movieapp.di

import com.example.movieapp.data.remote.MovieService
import com.example.movieapp.data.repository.MovieDataRepositoryImpl
import com.example.movieapp.domain.repository.MovieListDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun providesGetCurrentMovieRepository(
        service: MovieService
    ): MovieListDataRepository = MovieDataRepositoryImpl(
        service = service
    )
}