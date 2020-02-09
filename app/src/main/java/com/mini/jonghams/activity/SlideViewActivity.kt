package com.mini.jonghams.activity

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.mini.jonghams.R
import com.mini.jonghams.ViewPager.SlideViewPagerAdapter
import com.mini.jonghams.model.SliderItem
import kotlinx.android.synthetic.main.activity_slide_view.*
import java.util.*

class SlideViewActivity : AppCompatActivity() {
    private var TAG = SlideViewActivity::class.java.simpleName
    lateinit var sliderItems: MutableList<SliderItem>
    internal var firstCurrentItem = 1
    var activeSelected = 1
    internal var itemPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide_view)

        try {
            sliderItems = ArrayList()
            sliderItems.add(SliderItem(1, R.drawable.food_1))
            sliderItems.add(SliderItem(1, R.drawable.food_2))
            sliderItems.add(SliderItem(1, R.drawable.food_3))
            sliderItems.add(SliderItem(1, R.drawable.food_4))
            sliderItems.add(SliderItem(1, R.drawable.food_5))

            val adapter = SlideViewPagerAdapter(this, sliderItems)
            view_pager.adapter = adapter
            view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                }

                override fun onPageSelected(position: Int) {
                    println("Testing pos: " + position)
                    if (itemPosition > position) {
                        if (activeSelected == 0) {
                            activeSelected = sliderItems.size - 1
                        } else {
                            activeSelected--
                        }
                    } else {
                        if (activeSelected >= sliderItems.size - 1) {
                            activeSelected = 0
                        } else {
                            activeSelected++
                        }
                    }
                    itemPosition = position
                    setPageIndicator(activeSelected)
                }

                override fun onPageScrollStateChanged(state: Int) {}
            })

            for (i in sliderItems.indices) {
                val view = ImageView(this)
                view.setImageResource(R.drawable.ic_circle_blck)
                lyt_page_indicator.addView(view)
            }
            setPageIndicator(firstCurrentItem)
        } catch (ex: Exception) {
            Log.e(TAG, ex.message)
        }
    }

    fun setPageIndicator(position: Int) {
        var imageView: ImageView
        val lp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        lp.setMargins(5, 0, 5, 0)
        for (i in 0 until lyt_page_indicator.childCount) {
            imageView = lyt_page_indicator.getChildAt(i) as ImageView
            imageView.layoutParams = lp
            if (position == i) {
                imageView.setImageResource(R.drawable.ic_circle_red)
            } else {
                imageView.setImageResource(R.drawable.ic_circle_white)
            }
        }
    }
}
