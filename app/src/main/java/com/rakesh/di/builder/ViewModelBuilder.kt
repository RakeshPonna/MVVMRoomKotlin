package com.rakesh.di.builder

import androidx.lifecycle.ViewModelProvider
import com.rakesh.ui.base.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module(includes = [ViewModelModule::class])
abstract class ViewModelBuilder {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory) : ViewModelProvider.Factory
}