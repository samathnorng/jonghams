package com.mini.jonghams.adapter

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mini.jonghams.R
import com.mini.jonghams.databinding.LayoutItemCalendarBinding
import java.text.SimpleDateFormat
import java.util.*


class CalendarAdapter : RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder>() {

    private var itemList: Array<String> = emptyArray()

    fun setListData(list: Array<String>) {
        this.itemList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): CalendarViewHolder {
        val binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.layout_item_calendar, parent, false
        ) as LayoutItemCalendarBinding
        return CalendarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        val item: String? = itemList?.get(position)
        val now = Calendar.getInstance()
        var today = SimpleDateFormat("EEEE").format(now.time)
        if (item.equals(today)) {
            holder.binding.daysTv.typeface = Typeface.DEFAULT_BOLD
            holder.binding.workTimeTv.typeface = Typeface.DEFAULT_BOLD
        }
        holder.binding.data = item
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    open class CalendarViewHolder(val binding: LayoutItemCalendarBinding) :
        RecyclerView.ViewHolder(binding.root)
}
