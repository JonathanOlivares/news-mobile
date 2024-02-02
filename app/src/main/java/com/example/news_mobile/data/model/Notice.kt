package com.example.news_mobile.data.model

data class Notice(
    val author: String = "",
    val title: String = "",
    val description: String = "",
    val url: String = "",
    val urlToImage: String = "",
    val publishedAt: String = "",
    val content: String = "")


//Data class que corresponde a cada uno de los objetos (que se crearon en la clase Notice) en una
//lista llamada articles la cual debe llamarse igual a la que da la API porque sino, no se podrá
// traer los datos del servidor.
//Es una lista de noticias List<Notice>
data class NoticeList(val articles: List<Notice> = listOf())
