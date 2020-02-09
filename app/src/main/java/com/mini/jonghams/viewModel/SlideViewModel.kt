package com.mini.jonghams.viewModel

import androidx.lifecycle.ViewModel
import com.mini.jonghams.R
import com.mini.jonghams.model.SliderItem

class SlideViewModel : ViewModel() {
    var slideList: MutableList<SliderItem> = ArrayList()
    private var activeSelected = 1
    internal var itemPosition = 0

    init {
        slideList.add(SliderItem("Fried beef with masroom", R.drawable.food_1, 2.5))
        slideList.add(SliderItem("Fried beef with Cabbages", R.drawable.food_2, 3.5))
        slideList.add(SliderItem("Fried beef with bean", R.drawable.food_3, 1.5))
        slideList.add(SliderItem("Fried pork", R.drawable.food_4, 2.0))
        slideList.add(SliderItem("Fried fish", R.drawable.food_5, 1.5))
    }

    fun activeSelect(position: Int): Int {
        if (itemPosition > position) {
            if (activeSelected == 0) {
                activeSelected =
                    slideList.size - 1
            } else {
                activeSelected--
            }
        } else {
            if (activeSelected >= slideList.size - 1) {
                activeSelected = 0
            } else {
                activeSelected++
            }
        }
        itemPosition = position
        return activeSelected
    }
}
