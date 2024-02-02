package com.example.news_mobile.ui.notice

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ConcatAdapter
import com.example.news_mobile.R
import com.example.news_mobile.core.Resource
import com.example.news_mobile.data.model.Notice
import com.example.news_mobile.data.remote.NoticeDataSource
import com.example.news_mobile.databinding.FragmentNoticeBinding
import com.example.news_mobile.presentation.NoticeViewModel
import com.example.news_mobile.presentation.NoticeViewModelFactory
import com.example.news_mobile.repository.NoticeRepositoryImpl
import com.example.news_mobile.repository.RetrofitClient
import com.example.news_mobile.ui.notice.adapters.concat.NoticeAdapter
import com.example.news_mobile.ui.notice.adapters.concat.TechCrunchConcatAdapter


class NoticeFragment : Fragment(R.layout.fragment_notice), NoticeAdapter.OnNoticeClickListener {

    private lateinit var binding: FragmentNoticeBinding
    private val viewModel by viewModels<NoticeViewModel>{ NoticeViewModelFactory(NoticeRepositoryImpl(
        NoticeDataSource(RetrofitClient.webService)
    ))}

    //Ultimos pasos es generar una instancia del adapter

    private lateinit var concatAdapter: ConcatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNoticeBinding.bind(view)

        concatAdapter = ConcatAdapter()

        viewModel.fetchTechCrunchNotice().observe(viewLifecycleOwner, Observer {result ->
            when (result){
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    Log.d("LiveData", "Loading...")
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    Log.d("LiveData", "Tech: ${result.data}")
                    concatAdapter.apply {
                        addAdapter(0, TechCrunchConcatAdapter(NoticeAdapter(result.data.articles,  this@NoticeFragment)))
                    }

                    binding.rvNotice.adapter = concatAdapter
                }
                is Resource.Failure ->{
                    binding.progressBar.visibility = View.GONE
                    Log.d("Error", "${result.exception}")
                }
            }
        })
    }

    override fun onNoticeClick(notice: Notice) {
        Log.d("Notice", "OnNoticeCLick: $notice")
    }
}