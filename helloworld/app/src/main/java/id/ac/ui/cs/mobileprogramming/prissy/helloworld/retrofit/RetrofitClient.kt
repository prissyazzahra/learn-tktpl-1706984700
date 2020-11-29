package id.ac.ui.cs.mobileprogramming.prissy.helloworld.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val url = "https://745d81b27a6bcee6c95afe626e6fb658.m.pipedream.net"

    private val client = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val RETROFIT_SERVICE: ApiService = client.create(ApiService::class.java)
}