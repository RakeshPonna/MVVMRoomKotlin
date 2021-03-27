package com.rakesh.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.rakesh.data.db.ApplicationDataBase
import com.rakesh.data.model.Expense
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

const val TAG: String = "ExpenseRepository"

class ExpenseRepositoryImpl
@Inject constructor(private val applicationDataBase: ApplicationDataBase) : ExpenseRepository {


    override fun insertExpense(expense: Expense): Disposable {
        return applicationDataBase.expenseDao().insetExpense(expense).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe() {
            Log.d(TAG, "Expense record added to database ,  id : ${expense.title}")
        }
    }

    override fun getExpenses(): LiveData<MutableList<Expense>> {
        return  applicationDataBase.expenseDao().getAllExpenses()
    }

    override fun deleteExpense(expense: Expense) {
        TODO("Not yet implemented")
    }
}