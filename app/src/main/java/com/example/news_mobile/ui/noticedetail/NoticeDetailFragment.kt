package com.example.news_mobile.ui.noticedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.news_mobile.R
import com.example.news_mobile.databinding.FragmentNoticeDetailBinding


class NoticeDetailFragment : Fragment(R.layout.fragment_notice_detail) {

    private lateinit var binding: FragmentNoticeDetailBinding
    private val args by navArgs<NoticeDetailFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNoticeDetailBinding.bind(view)
        Glide.with(requireContext()).load(args.backgroundImageUrl).centerCrop().into(binding.imageBackground)
        binding.txtRowTitle.text = args.title
        binding.txtAuthor.text = args.author
        binding.txtPublishedAt.text = "Published at: ${args.publishedAt}"
        binding.txtContent.text = args.content
    }
}