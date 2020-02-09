package com.mini.jonghams.ViewPager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.mini.jonghams.R
import com.mini.jonghams.model.SliderItem
import kotlinx.android.synthetic.main.layout_item_slide.view.*

class SlideViewPagerAdapter(private var context: Context, private var itemList: List<SliderItem>) :
    PagerAdapter() {
    private var slidePosition = 0

    override fun getCount(): Int {
        return Integer.MAX_VALUE
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val holder = ViewHolder()
        val mLayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = mLayoutInflater.inflate(R.layout.layout_item_slide, container, false)
        holder.itemImage = itemView.img_slider as ImageView
        holder.name = itemView.item_name as TextView
        holder.price = itemView.item_price as TextView

        if (slidePosition > this.itemList.size - 1)
            slidePosition = 0

        holder.sliderItem = itemList[slidePosition]
        holder.itemImage.setImageDrawable(context.getDrawable(holder.sliderItem.drawable))
        holder.name.text = itemList[slidePosition].name
        holder.price.text = itemList[slidePosition].price.toString()
        (container as ViewPager).addView(itemView)
        holder.itemImage.scaleType = ImageView.ScaleType.FIT_XY

        slidePosition++
        return itemView
    }

    private class ViewHolder {
        lateinit var sliderItem: SliderItem
        lateinit var itemImage: ImageView
        lateinit var name: TextView
        lateinit var price: TextView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }

    override fun isViewFromObject(arg0: View, arg1: Any): Boolean {
        return arg0 === arg1 as View
    }

    override fun destroyItem(arg0: View, arg1: Int, arg2: Any) {
        (arg0 as ViewPager).removeView(arg2 as View)
    }
}