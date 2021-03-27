package com.rakesh.di.builder

import com.rakesh.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [MainActivityProviders::class])
    abstract fun bindActivity() : MainActivity
}