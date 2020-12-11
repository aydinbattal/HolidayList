package com.profjk.holidaylist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.profjk.holidaylist.R
import com.profjk.holidaylist.network.Holiday
import kotlinx.android.synthetic.main.holiday_list_item.view.*

/**
 * HolidayList created by aydin
 * student ID : 991521740
 * on 10/12/20 */

class HolidayAdapter(
    val context: Context,
    val holidaysList: MutableList<Holiday>,
    val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<HolidayAdapter.HolidayViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HolidayAdapter.HolidayViewHolder {

        val view: View = LayoutInflater.from(context).inflate(R.layout.holiday_list_item, null)
        return HolidayViewHolder(view)
    }

    override fun getItemCount(): Int {
        return holidaysList.size
    }

    override fun onBindViewHolder(holder: HolidayAdapter.HolidayViewHolder, position: Int) {
        holder.bind(holidaysList[position], itemClickListener)
    }

    inner class HolidayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvDate: TextView = itemView.tvDate
        var tvHolidayName: TextView = itemView.tvHolidayName

        fun bind(holiday: Holiday, clickListener: OnItemClickListener){
            tvDate.setText(holiday.date.toString())
            tvHolidayName.setText(holiday.date.toString())

            itemView.setOnClickListener{
                clickListener.onItemClicked(holiday)
            }
        }
    }
}


interface OnItemClickListener{
    fun onItemClicked(holiday: Holiday)
}