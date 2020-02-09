package com.mini.jonghams.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mini.jonghams.R
import com.mini.jonghams.databinding.LayoutItemProductBinding
import com.mini.jonghams.model.Product
import com.mini.jonghams.screens.main.ProductClickListener
import com.mini.jonghams.utills.loadSrc

class ProductAdapter(private val itemCallback: ProductClickListener?) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var itemList: List<Product>? = emptyList()

    fun setListData(list: List<Product>) {
        this.itemList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): ProductViewHolder {
        val binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.layout_item_product, parent,
            false
        ) as LayoutItemProductBinding

        binding.callback = itemCallback

        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item: Product? = itemList?.get(position)
        holder.binding.data = item
        holder.binding.image.loadSrc(item!!.imageUrl)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return itemList?.size ?: 0
    }

    open class ProductViewHolder(val binding: LayoutItemProductBinding) :
        RecyclerView.ViewHolder(binding.root)
}
