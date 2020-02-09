package com.mini.jonghams.viewModel

import androidx.lifecycle.ViewModel
import com.mini.jonghams.model.Product

class ProductViewModel : ViewModel() {
    var productList: MutableList<Product> = ArrayList()

    init {
        productList.add(
            Product(
                "សាច់គោបំពងល្ង",
                "https://www.abejero.net/wp-content/uploads/2015/04/MG_7374-Ongkrong-Beef-sm.jpg",
                3.50
            )
        )

        productList.add(
            Product(
                "សាច់គោបន្ទះដែក",
                "https://food.fnr.sndimg.com/content/dam/images/food/fullset/2013/6/19/0/WU0501H_peppercorn-roasted-beef-tenderloin-recipe_s4x3.jpg.rend.hgtvcom.826.620.suffix/1552487731049.jpeg",
                2.50
            )
        )

        productList.add(
            Product(
                "Tuna sandwich",
                "https://www.thespruceeats.com/thmb/PVK9Vi54ZyV7zLccJ5-3yjXnNfo=/960x0/filters:no_upscale():max_bytes(150000):strip_icc()/tuna-sald-sandwich-153064942-0eac25cff6ba42f48a4873a2739a971b.jpg",
                3.50
            )
        )
        productList.add(
            Product(
                "Shark soup",
                "https://ewscripps.brightspotcdn.com/dims4/default/6963377/2147483647/strip/true/crop/3264x1836+0+306/resize/1280x720!/quality/90/?url=https%3A%2F%2Fewscripps.brightspotcdn.com%2Fac%2F95%2F9e9158a84816b9f7225394bb1900%2Fshark-fin-cnn-040619.JPG",
                3.00
            )
        )
        productList.add(
            Product(
                "Fried fish with rice",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS5QvH_XrKbnWu2gwFlGqtgXghZ0X4kwaQGaUkKvobDQyfEZ1G3",
                15.00
            )
        )
        productList.add(
            Product(
                "Beef fried noodle",
                "https://www.abejero.net/wp-content/uploads/2015/04/MG_7374-Ongkrong-Beef-sm.jpg",
                3.50
            )
        )
    }
}
