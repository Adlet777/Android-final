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


class CountryAdapter : RecyclerView.Adapter<CountryAdapter.MyViewHolder>() {
    private var countryList = emptyList<Country>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.country_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = countryList[position]
        val country = holder.itemView.findViewById<TextView>(R.id.country)
        val iso = holder.itemView.findViewById<TextView>(R.id.iso)
        val slug = holder.itemView.findViewById<TextView>(R.id.slug)

        country.text = currentItem.Country
        iso.text = currentItem.ISO2
        slug.text = currentItem.Slug

        holder.itemView.setOnClickListener {
            val action = CountryFragmentDirections.actionCountryFragmentToStatsFragment2(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return countryList.size
    }


    fun setData(tagStat: List<Country>) {
        this.countryList = tagStat
        notifyDataSetChanged()
    }

    fun getData(): List<Country> {
        return this.countryList
    }
}