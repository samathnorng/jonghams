package com.mini.jonghams.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mini.jonghams.R
import com.mini.jonghams.adapter.CalendarAdapter
import com.mini.jonghams.databinding.RecyclerviewContainerBinding


class CalendarFragment : Fragment() {

    private lateinit var binding: RecyclerviewContainerBinding
    private lateinit var contactListAdapter: CalendarAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.recyclerview_container, container, false)
        contactListAdapter = CalendarAdapter()
        binding.apply {
            recyclerView.adapter = contactListAdapter
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val contactList = resources.getStringArray(R.array.calendar)
        contactListAdapter.setListData(contactList)
    }
}
