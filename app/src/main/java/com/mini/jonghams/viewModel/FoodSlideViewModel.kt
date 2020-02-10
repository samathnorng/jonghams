package com.mini.jonghams.viewModel

import androidx.lifecycle.ViewModel
import com.mini.jonghams.model.Food

class FoodSlideViewModel : ViewModel() {
    private var activeSelected = 1
    private var itemPosition = 0

    fun activeSelect(foodList: List<Food>, position: Int): Int {
        if (itemPosition > position) {
            if (activeSelected == 0) {
                activeSelected =
                    foodList.size - 1
            } else {
                activeSelected--
            }
        } else {
            if (activeSelected >= foodList.size - 1) {
                activeSelected = 0
            } else {
                activeSelected++
            }
        }
        itemPosition = position
        return activeSelected
    }
}
