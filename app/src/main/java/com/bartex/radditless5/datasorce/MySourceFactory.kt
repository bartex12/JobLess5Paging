package com.bartex.radditless5.datasorce

import com.bartex.radditless5.entity.Children
import androidx.paging.DataSource
import com.bartex.radditless5.ui.fragment.RedditViewModel

class MySourceFactory(val viewModel: RedditViewModel): DataSource.Factory<Int, Children>() {
    override fun create(): DataSource<Int, Children> {
        return MyPositionalDataSource(viewModel)
    }
}