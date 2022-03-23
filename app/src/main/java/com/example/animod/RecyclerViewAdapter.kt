package com.example.animod
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aniMod.CountriesQuery

class RecyclerViewAdapter(private val list:  List<CountriesQuery.Continent>)
    : RecyclerView.Adapter<CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CountryViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country: CountriesQuery.Continent = list[position]
        holder.bind(country)
    }

    override fun getItemCount(): Int = list.size
}