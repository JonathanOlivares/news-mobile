package com.example.news_mobile.application


//Object nos va a permitir es que cada vez que usemos AppConstants va usar la misma instancia, por
// lo que es un objeto, es decir esto es simplemente crear un objeto que vive en memoría y siempre
// que se llama, siempre tiene la misma instancia

object AppConstants {

    //API
    const val BASE_URL = "https://newsapi.org/v2/"
    const val API_KEY = "60408f4d78f54a1b8711b9e00b80d2b1"
}