package com.example.news_mobile.data.remote

import com.example.news_mobile.application.AppConstants
import com.example.news_mobile.data.model.NoticeList
import com.example.news_mobile.repository.WebService

//Con esto ya se tiene las llamadas del datSource al webService
class NoticeDataSource(private val webService: WebService) {

   suspend fun getTechCrunchNotice(): NoticeList = webService.getTechCrunchNotice(AppConstants.API_KEY)

}