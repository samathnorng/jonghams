package com.mini.jonghams.ViewPager;

import android.content.Context
import android.view.LayoutInflater
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.mini.jonghams.R
import com.mini.jonghams.model.SliderItem

class SlideViewPagerAdapter(private var context: Context, private var itemList: List<SliderItem>) :
    PagerAdapter() {
    private var mLayoutInflater: LayoutInflater =
        this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private var pos = 0

    override fun getCount(): Int {
        return Integer.MAX_VALUE
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val holder = ViewHolder()
        val itemView = mLayoutInflater.inflate(R.layout.adapter_view_pager, container, false)
        holder.itemImage = itemView.findViewById(R.id.img_slider) as ImageView

        if (pos > this.itemList.size - 1)
            pos = 0

        holder.sliderItem = this.itemList[pos]
        holder.itemImage.setImageDrawable(context.getDrawable(holder.sliderItem.imageDrawable))

        (container as ViewPager).addView(itemView)

        holder.itemImage.scaleType = ImageView.ScaleType.FIT_XY

        pos++
        return itemView
    }

    private class ViewHolder {
        lateinit var sliderItem: SliderItem
        lateinit var itemImage: ImageView
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