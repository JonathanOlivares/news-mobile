package com.example.news_mobile.repository

import com.example.news_mobile.application.AppConstants
import com.example.news_mobile.data.model.NoticeList
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("top-headlines")
    suspend fun TechCrunchNotice(@Query("apiKey")apiKey: String): NoticeList
}

//Ahora generamos el WebService con un objeto de Retrofit.
// Retrofit será la instancia que va a proporcionar la base URL y el convertidor JSON
// y esa instancia con el WebService.

//by lazy funciona para que cuando se llame a RetrofitClient.WebService va inicializar la variable
//lazy, es decir que de inicializar solo en el momento que se llame a webService, no antes, sólo
//será en el momento en que lo ejecutará.
object RetrofitClient{
    val webService by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}

//Ya se tiene el webService listo para ir a buscar la información al servidor.