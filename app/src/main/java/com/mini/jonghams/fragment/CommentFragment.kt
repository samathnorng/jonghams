package com.mini.jonghams.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mini.jonghams.R
import com.mini.jonghams.adapter.CommentAdapter
import com.mini.jonghams.databinding.RecyclerviewContainerBinding
import com.mini.jonghams.model.User
import com.mini.jonghams.screens.main.CommentClickListener
import com.mini.jonghams.viewModel.CommentViewModel
import org.koin.android.ext.android.inject


class CommentFragment : Fragment() {

    companion object {
        fun newInstance() = CommentFragment()
    }

    private val viewModel: CommentViewModel by inject()
    private lateinit var binding: RecyclerviewContainerBinding
    private lateinit var commentListAdapter: CommentAdapter

    private val itemClickCallback = object : CommentClickListener {
        override fun onItemClick(item: User) {
            println("Testing item: $item")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.recyclerview_container, container, false)
        commentListAdapter = CommentAdapter(itemClickCallback)
        binding.apply {
            recyclerView.adapter = commentListAdapter
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        commentListAdapter.setListData(viewModel.commentList)
    }

}
