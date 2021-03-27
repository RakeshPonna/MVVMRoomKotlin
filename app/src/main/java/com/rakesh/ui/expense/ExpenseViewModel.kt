package com.rakesh.ui.expense

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rakesh.data.ExpenseRepository
import com.rakesh.data.model.Expense
import com.rakesh.ui.base.BaseViewModel
import javax.inject.Inject

const val TAG = "ExpenseViewModel"

class ExpenseViewModel
@Inject constructor(private val expenseRepository: ExpenseRepository) : BaseViewModel() {

    val expenseData: MutableLiveData<MutableList<Expense>> by lazy {
        MutableLiveData<MutableList<Expense>>()
    }

    init {
        Log.d(TAG, "init block")
    }

    fun getExpenses(): LiveData<MutableList<Expense>> {
        return expenseRepository.getExpenses()
    }

    fun insertExpenseRecord(expense: Expense) {
        expenseRepository.insertExpense(expense)
    }


}