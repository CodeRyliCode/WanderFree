package com.example.animod

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aniMod.CountriesQuery


class CountryViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.recyclerview_item, parent, false)) {
    private var name: TextView? = null

    init {
        name = itemView.findViewById(R.id.name)
    }

    fun bind(countries: CountriesQuery.Continent) {
        name?.text = countries.toString()
        }
    }




