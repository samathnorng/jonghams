package com.mini.jonghams.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mini.jonghams.R
import com.mini.jonghams.databinding.LayoutItemProductBinding
import com.mini.jonghams.model.Food
import com.mini.jonghams.screens.main.FoodClickListener

class FoodAdapter(private val itemCallback: FoodClickListener?) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    private var itemList: List<Food>? = emptyList()

    fun setListData(list: List<Food>) {
        this.itemList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): FoodViewHolder {
        val binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.layout_item_product, parent,
            false
        ) as LayoutItemProductBinding

        binding.callback = itemCallback

        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val item: Food? = itemList?.get(position)
        holder.binding.data = item
        holder.binding.image.setImageResource(item!!.drawable)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return itemList?.size ?: 0
    }

    open class FoodViewHolder(val binding: LayoutItemProductBinding) :
        RecyclerView.ViewHolder(binding.root)
}
