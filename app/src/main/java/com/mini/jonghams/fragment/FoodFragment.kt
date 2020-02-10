package com.mini.jonghams.fragment

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mini.jonghams.R
import com.mini.jonghams.activity.FoodSlideActivity
import com.mini.jonghams.adapter.FoodAdapter
import com.mini.jonghams.model.Food
import com.mini.jonghams.screens.main.FoodClickListener
import com.mini.jonghams.viewModel.FoodViewModel
import org.koin.android.ext.android.inject
import java.io.Serializable


class FoodFragment : Fragment() {


    private val viewModel: FoodViewModel by inject()
    private lateinit var foodListAdapter: FoodAdapter

    private val itemClickCallback = object : FoodClickListener {
        override fun onItemClick(item: Food) {
            val intent = Intent(context, FoodSlideActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, viewModel.foodList as Serializable)
            }
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        foodListAdapter = FoodAdapter(itemClickCallback)
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
                adapter = foodListAdapter
            }
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        foodListAdapter.setListData(viewModel.foodList)
    }
}
