package com.mplr.rappimovie.platform.di.module

import com.mplr.rappimovie.logger.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
class LoggerModule {

    @Provides
    fun logger(): Logger {
        return Logger()
    }

}