package com.mini.jonghams.activity

import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.MenuItem
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.mini.jonghams.R
import com.mini.jonghams.ViewPager.FoodSlidePagerAdapter
import com.mini.jonghams.model.Food
import com.mini.jonghams.viewModel.FoodSlideViewModel
import kotlinx.android.synthetic.main.activity_slide_view.*
import org.koin.android.ext.android.inject

class FoodSlideActivity : AppCompatActivity() {
    private val viewModelFood: FoodSlideViewModel by inject()
    private var foodList = emptyList<Food>()
    private var firstCurrentItem = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide_view)
        setSupportActionBar(toolbar)
        if (intent.extras != null) {
            foodList = intent.extras?.getSerializable(EXTRA_MESSAGE) as List<Food>
        }

        if (supportActionBar != null) supportActionBar!!.title = "Menus"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val adapter = FoodSlidePagerAdapter(this, foodList)
        view_pager.adapter = adapter
        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                setPageIndicator(viewModelFood.activeSelect(foodList, position))
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        for (i in foodList.indices) {
            val view = ImageView(this)
            view.setImageResource(R.drawable.ic_circle_blck)
            lyt_page_indicator.addView(view)
        }
        setPageIndicator(firstCurrentItem)
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
