package com.mplr.rappimovie.platform.di.module

import com.mplr.rappimovie.api.CoreHomeApi
import com.mplr.rappimovie.repositories.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ActivityComponent::class, ViewModelComponent::class)
class MainActivityModule {

    @Provides
    @ViewModelScoped
    fun movieRepositoryProvider(apiService: CoreHomeApi) = MovieRepository(apiService)

}