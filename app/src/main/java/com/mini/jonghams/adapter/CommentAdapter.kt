package com.mini.jonghams.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mini.jonghams.R
import com.mini.jonghams.databinding.LayoutItemCommentBinding
import com.mini.jonghams.model.User
import com.mini.jonghams.screens.main.CommentClickListener
import com.mini.jonghams.utills.loadSrc

class CommentAdapter(private val itemCallback: CommentClickListener?) :
    RecyclerView.Adapter<CommentAdapter.UserViewHolder>() {

    private var itemList: List<User>? = null

    fun setListData(list: List<User>) {
        this.itemList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): UserViewHolder {
        val binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.layout_item_comment, parent,
            false
        ) as LayoutItemCommentBinding

        binding.callback = itemCallback
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item: User? = itemList?.get(position)
        holder.binding.data = item
        holder.binding.userImage.loadSrc(item!!.imageUrl)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return itemList?.size ?: 0
    }

    open class UserViewHolder(val binding: LayoutItemCommentBinding) :
        RecyclerView.ViewHolder(binding.root)
}
