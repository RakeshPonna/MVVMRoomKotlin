package com.rakesh.di.module

import android.app.Application
import androidx.room.Room
import com.rakesh.data.db.ApplicationDataBase
import com.rakesh.data.db.ExpenseDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideApplicationDataBase(application: Application): ApplicationDataBase {
        return Room.databaseBuilder(
            application,
            ApplicationDataBase::class.java,
            ApplicationDataBase.DB_NAME
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
    }

    @Provides
    fun provideExpenseDao(applicationDataBase: ApplicationDataBase): ExpenseDao {
        return applicationDataBase.expenseDao()
    }

}