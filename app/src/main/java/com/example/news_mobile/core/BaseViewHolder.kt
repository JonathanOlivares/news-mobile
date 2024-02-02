package com.example.news_mobile.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView


//Esta clase se ocupará paratodo, se hará abstracto, es decir se podra rehusar en donde se quiera y
// va a facilitar la cración de adaptadores.
//BaseViewHolder tiene un génerico T que se le puede pasar cualquier tipo de ViewHolder, el cual
// tendra un itemView que será una vista, el cual va a retornar un RecyclerView.ViewHolder de la
// vista que se le está pasando, para finalizar lo unico que se requiere es agregar un método más
// que es un abstract fun bind el cual se va a encargar de agarrar cada uno de los elementos de la
// noticia y ponerle los datos que se requiere, como por ejemplo poner la imagen de la noticia, la
// descripción, etc.

abstract class BaseViewHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView){
    abstract fun bind(item: T)
}