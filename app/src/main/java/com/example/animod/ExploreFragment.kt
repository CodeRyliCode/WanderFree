package com.example.animod

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.aniMod.CountriesQuery
import com.example.animod.ApolloClient.getApolloClient
import com.example.animod.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import com.apollographql.apollo3.ApolloClient

class ExploreFragment : Fragment() {
    private lateinit var binding: ActivityMainBinding
    private var apolloClient: ApolloClient = getApolloClient()
    private var job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_explore)
    }


    fun getCountries(view: View) {
        coroutineScope.launch {
            makeSearchRequest(binding.editText.text.toString())
        }
    }

    private suspend fun makeSearchRequest(value: String) {
        val response = apolloClient.query(CountriesQuery()).execute()


        binding.recyclerview.apply {
            adapter = response.data?.continents.let { RecyclerViewAdapter(it as List<CountriesQuery.Continent>)}
            Log.d("List of Countries", "Success ${response.data}")

        }
    }
}


