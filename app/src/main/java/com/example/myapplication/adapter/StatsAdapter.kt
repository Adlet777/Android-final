package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.fragment.CountryFragmentDirections
import com.example.myapplication.model.Country
import com.example.myapplication.model.Stats


class StatsAdapter : RecyclerView.Adapter<StatsAdapter.MyViewHolder>() {
    private var statsList = emptyList<Stats>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.stats_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = statsList[position]

        var lineResponse = "country: " + currentItem.Country + "; active: " + currentItem.Active + "; city: " + currentItem.City+ "; country code: " + currentItem.CountryCode + "; city code: " + currentItem.CityCode+ "; confirmed: " + currentItem.Confirmed+ "; deaths: " + currentItem.Deaths+ "; date: " + currentItem.Date+ "; id: " + currentItem.ID+ "; lat: " + currentItem.Lat+ "; lon: " + currentItem.Lon+ "; province: " + currentItem.Province+ "; recovered: " + currentItem.Recovered

        var stats = holder.itemView.findViewById<TextView>(R.id.stats)

        stats.text = lineResponse
    }

    override fun getItemCount(): Int {
        return statsList.size
    }


    fun setData(tagStat: List<Stats>) {
        this.statsList = tagStat
        notifyDataSetChanged()
    }

    fun getData(): List<Stats> {
        return this.statsList
    }
}