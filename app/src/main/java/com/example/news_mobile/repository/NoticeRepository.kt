package com.example.news_mobile.repository

import com.example.news_mobile.data.model.NoticeList

interface NoticeRepository {
    suspend fun getTechCrunchNotice(): NoticeList
}