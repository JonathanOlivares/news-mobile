package com.example.news_mobile.repository

import com.example.news_mobile.data.model.NoticeList
import com.example.news_mobile.data.remote.NoticeDataSource

//Ya que el repositorio va al dataSource a buscar información,enlazamos una clase con otra creando
// una instancia dentro del constructor del repositorio que se va a llamar datasource.
class NoticeRepositoryImpl(private val dataSource: NoticeDataSource): NoticeRepository {
    override suspend fun getTechCrunchNotice(): NoticeList = dataSource.getTechCrunchNotice()
    //Igualamos la función a su resultado que sería lo mismo que poner return.

    //Con esto ya se tiene el método que va llamar al datSource para buscar la información.


}