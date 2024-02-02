package com.example.news_mobile.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.news_mobile.core.Resource
import com.example.news_mobile.repository.NoticeRepository
import kotlinx.coroutines.Dispatchers

//Se importa lifecycle ya que el ciclo de vida y el ViewModel están muy dados de la mano y trabajan
// en conjunto para poder garantizar a la interfaz que siempre tendrá los ultimos datos que ha
// solicitado en el servidor.

class NoticeViewModel(private val repo: NoticeRepository): ViewModel() {
    fun fetchTechCrunchNotice() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getTechCrunchNotice()))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
}

class NoticeViewModelFactory(private val repo: NoticeRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(NoticeRepository::class.java).newInstance(repo)
    }
}

//Para hacer la llamada que va a ir al servidor a buscar información, se necesita asignarle un hilo
// de ejecución, hay varios hilos de ejecución para correr una corutina pero el más usado
//es Dispatchers.IO, los más usados son .IO, .Default, .Main, pero el más usado en los proces de
// servidores es, ir a buscar información es .IO, si se quiere hacer procesos con un mayor nivel de
// computo se puede usar Default y si se van a correr procesos en el main thread o en el mismo hilo
// principal donde corre la aplicación se puede ocupar main.

//Usaremos un try catch para correr dentro la corutina

