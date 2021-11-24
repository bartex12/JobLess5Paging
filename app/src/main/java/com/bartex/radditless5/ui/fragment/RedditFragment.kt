package com.bartex.radditless5.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bartex.radditless5.datasorce.MySourceFactory
import com.bartex.radditless5.R
import com.bartex.radditless5.RedditPageAdapter
import com.bartex.radditless5.entity.Children
import java.util.concurrent.Executors

class RedditFragment : Fragment() {

    private lateinit var rvReddit:RecyclerView
    private lateinit var pageAdapter: RedditPageAdapter
    val viewModel by lazy{
        ViewModelProvider(this)[RedditViewModel::class.java]
    }
    private lateinit var pagedListLiveData : LiveData<PagedList<Children>>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reddit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        initAdapter()
        initPageList()

        pagedListLiveData.observe(viewLifecycleOwner, {pagedListChildren->
            //передаём PagedList<Photo> в адаптер
            pageAdapter.submitList(pagedListChildren)
        })

    }
    private fun initViews(view: View){
        rvReddit = view.findViewById(R.id.rv_reddit)
    }
    private fun initAdapter() {
        val layoutManager = LinearLayoutManager(requireActivity())
        rvReddit.layoutManager = layoutManager
        // Adapter
        pageAdapter = RedditPageAdapter()
        // RecyclerView
        rvReddit.adapter = pageAdapter
    }

    private fun initPageList() {
        //конфигурируем PagedList
        val config : PagedList.Config = getPageListConfig()
        //так как LivePagedList создаёт DataSource самостоятельно, нужна фабрика
        val sourceFactory: MySourceFactory = MySourceFactory(viewModel)
        //создаём LivaData в которую будет приходить PagedList,
        // используя фабрику и конфигурацию
        pagedListLiveData  =
            LivePagedListBuilder(sourceFactory, config)
                .setFetchExecutor(Executors.newSingleThreadExecutor())
                .build()
    }

    private fun getPageListConfig(): PagedList.Config {
        return PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(10)
            .setInitialLoadSizeHint(30)
            .setPrefetchDistance(10)
            .build()
    }
}