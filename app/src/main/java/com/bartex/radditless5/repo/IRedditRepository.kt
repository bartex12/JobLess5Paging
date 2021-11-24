package com.bartex.radditless5.repo

import com.bartex.radditless5.entity.Children

interface IRedditRepository {
    fun loadData(pageNumber:Int, pageSize:Int):List<Children>?
}