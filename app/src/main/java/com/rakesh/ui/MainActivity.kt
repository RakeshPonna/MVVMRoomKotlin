package com.rakesh.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.rakesh.data.model.Expense
import com.rakesh.mvvmroomkotlin.R
import com.rakesh.mvvmroomkotlin.databinding.ActivityMainBinding
import com.rakesh.mvvmroomkotlin.databinding.DilaogExpenseEntryBinding
import com.rakesh.ui.expense.ExpenseViewModel
import com.rakesh.utils.Util
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

   @Inject
    lateinit var viewmodelFactory: ViewModelProvider.Factory

    private val viewModel: ExpenseViewModel by lazy {
        ViewModelProviders.of(this, viewmodelFactory).get(ExpenseViewModel::class.java)
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun addExpenseView(view: View) {
        val builder = AlertDialog.Builder(this)
        var alertDialog : AlertDialog? =null
        builder.setTitle("Add Expenses")
        val binding: DilaogExpenseEntryBinding = DataBindingUtil
            .inflate(LayoutInflater.from(this), R.layout.dilaog_expense_entry, null, false)
        binding.dialogLoginBtn.setOnClickListener {
            val expense = Expense(binding.dialogTitleEt.text.toString(),Util.getDate(),
                binding.dialogAmountEt.text.toString().toDouble())
            viewModel.insertExpenseRecord(expense)
            alertDialog?.dismiss()
        }
        builder.setView(binding.root)
         alertDialog =  builder.show()
    }
}