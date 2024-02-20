package com.example.news_mobile.ui.notice.adapters.concat

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.news_mobile.core.BaseViewHolder
import com.example.news_mobile.data.model.Notice
import com.example.news_mobile.databinding.NoticeItemBinding

// Dentro del adapter, como el RecyclerView.Adapter pide un ViewHolder, se le dará el BaseViewHolder
// y se le pondrá un asterisco dentro para representar cualquier tipo de ViewHolder, luego pide
// implementar los métodos.

// Ahora se  debe crear, lo que va buscar la interfaz, que va a inflar cada elemento de la lista.
// el cuál será itemBinding que llevará a NoticeItemBinding, que cómo se mencionó con anterioridad
// binding facilitará acceder a la vista.
// Lo que se de hacer es llamar al layout que infla esa vista, es decir llamarla.
// En resumen lo que hace itemBinding es simplemente lo mismoq que cuando se hace el contenido en una
// activity para inflar una layout con R.layout o en un fragment cuando hacemos el inflate del
// onCreateView.

class NoticeAdapter(private val noticeList: List<Notice>,
                    private val itemClickListener: OnNoticeClickListener
): RecyclerView.Adapter<BaseViewHolder<*>>() {
    interface  OnNoticeClickListener{
        fun onNoticeClick(notice: Notice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = NoticeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = NoticeViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position = holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION}
                ?: return@setOnClickListener
            itemClickListener.onNoticeClick(noticeList[position])
        }
        return holder
    }
    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is NoticeViewHolder -> holder.bind(noticeList[position])
        }
    }
    override fun getItemCount(): Int = noticeList.size

    private inner class NoticeViewHolder(
        val binding: NoticeItemBinding,
        val context: Context
    ): BaseViewHolder<Notice>(binding.root){
        override fun bind(item: Notice) {
            Glide.with(context).load(item.urlToImage).centerCrop().into(binding.imgNotice)
            binding.txtTitleNoticeItem.text = item.title
            binding.txtDescriptionBookItem.text = item.description
            binding.txtDateBookItem.text = item.publishedAt
        }
    }
}

