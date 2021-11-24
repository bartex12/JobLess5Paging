package com.bartex.radditless5.ui.fragment

import androidx.lifecycle.ViewModel
import com.bartex.radditless5.repo.IRedditRepository
import com.bartex.radditless5.repo.RedditRepository
import com.bartex.radditless5.entity.Children

class RedditViewModel:ViewModel() {
    val  redditRepository: IRedditRepository = RedditRepository()

    fun loadData(pageNumber:Int, pageSize:Int):List<Children>?{
        return redditRepository.loadData(pageNumber, pageSize)
    }
}