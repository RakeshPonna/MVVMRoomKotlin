package com.rakesh.di.module

import com.rakesh.data.ExpenseRepository
import com.rakesh.data.ExpenseRepositoryImpl
import com.rakesh.data.db.ApplicationDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
@Module(includes = [DataBaseModule::class])
class RepositoryModule {

    @Provides
    @Singleton
    fun providesExpenseRep(applicationDataBase: ApplicationDataBase) : ExpenseRepository{
        return ExpenseRepositoryImpl(applicationDataBase)
    }

}