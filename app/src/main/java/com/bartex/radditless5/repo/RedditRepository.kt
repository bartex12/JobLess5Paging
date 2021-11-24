package com.bartex.radditless5.repo

import com.bartex.radditless5.entity.Children
import com.bartex.radditless5.entity.ResultFromNet
import retrofit2.Response
import java.util.concurrent.CountDownLatch

class RedditRepository: IRedditRepository {

    override fun loadData(pageNumber: Int, pageSize: Int): List<Children>? {
       var redditList : List<Children>? = listOf()
        var response: Response<ResultFromNet?>?
       //синхронизация
        val startSignal = CountDownLatch(1)
        Thread{
            val iphoto: IReddit = RedditSource.API
            response = iphoto.loadRedditData().execute()
            val apiResults:ResultFromNet?  =  response?.body()
            //переходим к списку Children
            redditList = apiResults?.data?.children
            //разрешаем работу основного потока для возврата данных после окончания этого
            startSignal.countDown()
        }.start()
        startSignal.await()
        return redditList
    }
}