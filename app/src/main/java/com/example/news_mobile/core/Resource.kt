package com.example.news_mobile.core

import java.lang.Exception

//esta clase será para retornar tres estados para retornar estados y para poder trabajarlos en
// kotlin hay algo llamado Sealed clases (clases selladas) que funcionan para este proposito en
// especial. Esto de las clases selladas y el uso de genericos siempre se ocupan según fuentes de
// internet cuando uno crea proyectos en kotlin -junto con el uso de genericos- y sólo se lo se
// haran una sola vez.

sealed class Resource<out T> {
    class Loading<out T>: Resource<T>()

    data class Success<out T>(val data: T):Resource<T>()

    data class Failure(val exception: Exception):Resource<Nothing>()
}