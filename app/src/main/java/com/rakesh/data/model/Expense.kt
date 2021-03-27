package com.rakesh.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense_table")
data class Expense(
    var title: String?,
    var date: String?,
    var amount: Double?

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}