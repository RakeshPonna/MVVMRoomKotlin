package com.rakesh.data

import androidx.lifecycle.LiveData
import com.rakesh.data.model.Expense
import io.reactivex.disposables.Disposable
import java.lang.Exception


interface ExpenseRepository {

    fun insertExpense(expense: Expense) : Disposable

    fun getExpenses():LiveData<MutableList<Expense>>

    fun deleteExpense(expense: Expense)
}