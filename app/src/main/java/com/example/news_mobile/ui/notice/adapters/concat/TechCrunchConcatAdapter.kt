package com.example.news_mobile.ui.notice.adapters.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.news_mobile.core.BaseConcatHolder
import com.example.news_mobile.databinding.NoticeRowBinding

class TechCrunchConcatAdapter (private val noticeAdapter: NoticeAdapter):RecyclerView.Adapter<BaseConcatHolder<*>>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding = NoticeRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when(holder){
            is ConcatViewHolder -> holder.bind(noticeAdapter)
        }
    }

    override fun getItemCount(): Int = 1

    private inner class ConcatViewHolder (val binding: NoticeRowBinding): BaseConcatHolder<NoticeAdapter>(binding.root){
        override fun bind(adapter: NoticeAdapter) {
            binding.rvNoticeRow.adapter = adapter
        }
    }
}