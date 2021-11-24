package com.bartex.radditless5.repo

import com.bartex.radditless5.entity.ResultFromNet
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IReddit {

    @GET("r/aww/hot.json")
    fun loadRedditData(): Call<ResultFromNet>

//    @GET("r/cats/search.json")
//    fun loadRedditData(
//        @Query("q")text: String = "cat"
//    ): Call<ResultFromNet>
}