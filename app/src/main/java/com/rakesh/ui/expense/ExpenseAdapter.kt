package com.rakesh.ui.expense

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.rakesh.data.model.Expense
import com.rakesh.mvvmroomkotlin.BR
import com.rakesh.mvvmroomkotlin.databinding.RowExpensesBinding
import com.rakesh.ui.base.DataBindingViewHolder


class ExpenseAdapter(
    private var items: MutableList<Expense> = arrayListOf()
) : RecyclerView.Adapter<ExpenseAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowExpensesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    fun add(list: MutableList<Expense>) {
        items.addAll(list)
    }

    inner class ViewHolder(dataBinding: ViewDataBinding) :
        DataBindingViewHolder<Expense>(dataBinding) {

        override fun onBind(t: Expense): Unit = with(t) {
            dataBinding.setVariable(BR.dataItem, t)
        }

    }
}

@BindingAdapter("amount")
fun amountConverter(view: AppCompatTextView, value: String?) {
    if (value != null) {
        with(view) { setText(value.toBigDecimal().toString()) }
    }
}