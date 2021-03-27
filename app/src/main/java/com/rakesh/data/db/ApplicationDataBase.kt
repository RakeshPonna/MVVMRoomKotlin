package com.rakesh.data.db

import android.content.Context
import androidx.room.*
import com.rakesh.data.model.Expense

@Database(entities = [Expense::class],version = ApplicationDataBase.VERSION)
abstract class ApplicationDataBase : RoomDatabase() {

    companion object {
        const val DB_NAME = "expense.db"
        const val VERSION = 1

        private val LOCK = Any()

        private var INSTANCE: ApplicationDataBase? = null

        fun getInstance(context: Context): ApplicationDataBase {
            synchronized(LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext, ApplicationDataBase::class.java,
                        DB_NAME
                    ).build()
                }
                return INSTANCE!!
            }
        }
    }

    abstract fun expenseDao(): ExpenseDao

}