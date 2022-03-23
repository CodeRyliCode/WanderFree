package com.example.animod
import okhttp3.OkHttpClient
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient


object ApolloClient {
    const val BASE_URL = "https://countries.trevorblades.com/graphql"
    private var apClient: ApolloClient? = null
    //Singleton pattern
    @JvmStatic
    fun getApolloClient(): ApolloClient {
        apClient?.let {
            return it
        } ?: kotlin.run {
            apClient = ApolloClient.Builder()
                .okHttpClient(
                    OkHttpClient.Builder()
                        .build()
                )
                .serverUrl(BASE_URL)
                .build()
        }
        return apClient!!
    }
}