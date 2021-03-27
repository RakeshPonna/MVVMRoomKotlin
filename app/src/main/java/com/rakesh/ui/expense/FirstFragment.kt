package com.rakesh.ui.expense

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.rakesh.data.model.Expense
import com.rakesh.mvvmroomkotlin.databinding.FragmentFirstBinding
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_first.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: ExpenseViewModel by lazy {
        ViewModelProviders.of(requireActivity(), viewModelFactory).get(ExpenseViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val expenseAdapter: ExpenseAdapter by lazy {
        ExpenseAdapter(arrayListOf())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = expenseAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        with(viewModel) {
            getExpenses().observe(this@FirstFragment, Observer {
                refreshItems(it)
            })
        }
    }
    private fun refreshItems(it: MutableList<Expense>?) {
        it?.run {
            expenseAdapter.add(it)
            expenseAdapter.notifyDataSetChanged()
        }
    }
}