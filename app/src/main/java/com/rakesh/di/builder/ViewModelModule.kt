package com.rakesh.di.builder

import androidx.lifecycle.ViewModel
import com.rakesh.di.qualifier.ViewModelKey
import com.rakesh.ui.expense.ExpenseViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ExpenseViewModel::class)
    abstract fun bindViewModel(expenseViewModel: ExpenseViewModel): ViewModel
}