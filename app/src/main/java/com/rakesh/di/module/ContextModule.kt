package com.rakesh.di.module

import android.app.Application
import android.content.Context
import com.rakesh.di.builder.ViewModelBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelBuilder::class])
class ContextModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }
}