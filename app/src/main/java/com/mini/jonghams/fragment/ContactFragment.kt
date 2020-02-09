package com.mini.jonghams.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.mini.jonghams.R
import com.mini.jonghams.activity.ShopDetailActivity
import com.mini.jonghams.databinding.ContactFragmentBinding
import com.mini.jonghams.screens.main.ContactClickListener


class ContactFragment : Fragment() {
    private lateinit var binding: ContactFragmentBinding
    private val itemClickCallback = object : ContactClickListener {
        override fun onItemClick(phoneNum: String) {
            if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED) && activity is ShopDetailActivity) {
                (activity as ShopDetailActivity).setupPhoneCall(phoneNum)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.contact_fragment, container, false)
        binding.callback = itemClickCallback
        binding.data = binding.phoneTv.text.toString()
        return binding.root
    }
}
