package com.mini.jonghams.viewModel

import androidx.lifecycle.ViewModel
import com.mini.jonghams.R
import com.mini.jonghams.model.Food

class FoodViewModel : ViewModel() {
    var foodList: MutableList<Food> = ArrayList()

    init {
        foodList.add(Food("ឆាសាច់គោលាយផ្សិត", R.drawable.food_1, 3.50))
        foodList.add(Food("ឆាសាច់គោជាមួយស្ពៃ", R.drawable.food_2, 2.50))
        foodList.add(Food("Fried beef with bean", R.drawable.food_3, 3.50))
        foodList.add(Food("Fried pork", R.drawable.food_4, 3.00))
        foodList.add(Food("ត្រីរស់ខ", R.drawable.food_5, 15.00))
        foodList.add(Food("ត្រីចៀន", R.drawable.food_6, 3.50))
    }
}
