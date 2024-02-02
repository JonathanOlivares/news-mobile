package com.example.news_mobile.ui.notice

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.news_mobile.R
import com.example.news_mobile.core.Resource
import com.example.news_mobile.data.remote.NoticeDataSource
import com.example.news_mobile.databinding.FragmentNoticeBinding
import com.example.news_mobile.presentation.NoticeViewModel
import com.example.news_mobile.presentation.NoticeViewModelFactory
import com.example.news_mobile.repository.NoticeRepository
import com.example.news_mobile.repository.NoticeRepositoryImpl
import com.example.news_mobile.repository.RetrofitClient
import com.example.news_mobile.repository.WebService
import kotlin.math.log


class NoticeFragment : Fragment(R.layout.fragment_notice) {

    private lateinit var binding: FragmentNoticeBinding
    private val viewModel by viewModels<NoticeViewModel>{ NoticeViewModelFactory(NoticeRepositoryImpl(
        NoticeDataSource(RetrofitClient.webService)
    ))}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNoticeBinding.bind(view)

        viewModel.fetchTechCrunchNotice().observe(viewLifecycleOwner, Observer {result ->
            when (result){
                is Resource.Loading -> {
                    Log.d("LiveData", "Loading...")
                }
                is Resource.Success -> {
                    Log.d("LiveData", "${result.data}")
                }
                is Resource.Failure ->{
                    Log.d("Error", "${result.exception}")
                }
            }
        })
    }
}