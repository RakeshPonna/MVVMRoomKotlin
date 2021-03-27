package com.rakesh.di.component

import android.app.Application
import com.rakesh.coreapp.MyApplication
import com.rakesh.di.builder.ActivityBuilder
import com.rakesh.di.module.ContextModule
import com.rakesh.di.module.DataBaseModule
import com.rakesh.di.module.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [DataBaseModule::class,
        AndroidSupportInjectionModule::class,
        RepositoryModule::class,
        ActivityBuilder::class,
        ContextModule::class
        ]
)
interface ApplicationComponent : AndroidInjector<MyApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

}