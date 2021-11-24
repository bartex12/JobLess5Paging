package com.bartex.radditless5.repo

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RedditSource {
    val API: IReddit
    init {
        API = createAdapter()
    }

    private fun createAdapter(): IReddit {
        val adapter = Retrofit.Builder()
            .baseUrl("https://www.reddit.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
        return adapter.create(IReddit::class.java)
    }

}