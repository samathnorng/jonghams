package com.mini.jonghams.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mini.jonghams.activity.SlideViewActivity
import com.mini.jonghams.R
import com.mini.jonghams.adapter.ProductAdapter
import com.mini.jonghams.model.Product
import com.mini.jonghams.screens.main.ProductClickListener
import com.mini.jonghams.viewModel.ProductViewModel
import org.koin.android.ext.android.inject


class ProductFragment : Fragment() {

    private val viewModel: ProductViewModel by inject()
    private lateinit var productListAdapter: ProductAdapter

    private val itemClickCallback = object : ProductClickListener {
        override fun onItemClick(item: Product) {
            println("Testing item: $item")

            val intent = Intent(context, SlideViewActivity::class.java).apply {
                //  putExtra(EXTRA_MESSAGE, message)
            }
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productListAdapter = ProductAdapter(itemClickCallback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.recyclerview_container, container, false)
        if (view is RecyclerView) {
            with(view) {
                layoutManager = GridLayoutManager(context, 3)
                adapter = productListAdapter
            }
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        productListAdapter.setListData(viewModel.productList)
    }
}
