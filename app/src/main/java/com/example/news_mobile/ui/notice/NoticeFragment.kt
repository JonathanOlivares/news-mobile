package com.example.news_mobile.ui.notice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.news_mobile.R
import com.example.news_mobile.databinding.FragmentNoticeBinding


class NoticeFragment : Fragment(R.layout.fragment_notice) {

    private lateinit var binding: FragmentNoticeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNoticeBinding.bind(view)
    }
}