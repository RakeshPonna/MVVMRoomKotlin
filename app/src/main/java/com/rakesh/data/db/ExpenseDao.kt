package com.rakesh.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rakesh.data.model.Expense
import io.reactivex.Completable

@Dao
interface ExpenseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insetExpense(expense : Expense) : Completable

    @Query("SELECT * FROM expense_table")
    fun getAllExpenses():LiveData<MutableList<Expense>>

    @Delete
    fun deleteExpenseRecord(expense: Expense):Completable

}