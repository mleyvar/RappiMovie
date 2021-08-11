package com.mplr.rappimovie.platform.di.component

import com.mplr.rappimovie.platform.di.module.LoggerModule
import com.mplr.rappimovie.platform.di.module.MainActivityModule
import com.mplr.rappimovie.platform.di.module.RetrofitModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MainActivityModule::class,
        RetrofitModule::class,
        LoggerModule::class
    ]
)
interface MainComponent {}