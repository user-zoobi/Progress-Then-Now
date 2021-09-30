package com.example.roomdb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.roomdb.adapter.UserAdapter
import com.example.roomdb.db.UserDatabase
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        GlobalScope.launch {
            context.let {
                val getAll = it?.let { it1 -> UserDatabase.getInstance(it1).userDao.selectUsers() }
                recyclerView.adapter = getAll?.let { it1 -> UserAdapter(it1) }
            }
        }

        next_button.setOnClickListener {
            val addUser = AddFragment()
            requireFragmentManager().beginTransaction().apply {
                replace(R.id.fragment, addUser).addToBackStack(null).commit()
            }
        }
    }
}