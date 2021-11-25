package com.bartex.radditless5.datasorce

import android.util.Log
import androidx.paging.PositionalDataSource
import com.bartex.radditless5.entity.Children
import com.bartex.radditless5.ui.fragment.RedditViewModel

class MyPositionalDataSource(private val viewModel: RedditViewModel) : PositionalDataSource<Children>() {
    companion object{
        const val  TAG = "RedditLess5"
    }
    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Children>) {
        Log.d(TAG," MyPositionalDataSource loadInitial  " +
                "requestedStartPosition = ${params.requestedStartPosition}" +
                " requestedLoadSize = ${params.requestedLoadSize} " +
                "pageSize = ${params.pageSize}")

        val result :List<Children>? =
            viewModel.loadData(params.pageSize,  params.requestedLoadSize)
        result?. let{
            callback.onResult(result, 0)
        }
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Children>) {
        Log.d(TAG," MyPositionalDataSource loadRange  " +
                "startPosition = ${params.startPosition} " +
                "loadSize = ${params.loadSize}")

        val result :List<Children>? =
            viewModel.loadData(params.startPosition,params.loadSize )
        result?. let{
            callback.onResult(result)
        }
    }
}