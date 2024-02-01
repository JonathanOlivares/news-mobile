package com.example.news_mobile.ui.noticedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.news_mobile.R
import com.example.news_mobile.databinding.FragmentNoticeDetailBinding


class NoticeDetailFragment : Fragment(R.layout.fragment_notice_detail) {

    private lateinit var binding: FragmentNoticeDetailBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNoticeDetailBinding.bind(view)
    }
}