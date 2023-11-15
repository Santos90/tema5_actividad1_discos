package com.example.tema5_actividad1_discos.POJO

import com.example.tema5_actividad1_discos.R

class Cancion (private  var numCancion : Int,
                private var nombre: String,
                private var duracion: Float,
                private var imagen: Int = R.drawable.auriculares) {


    fun getNumCancion(): Int = numCancion
    fun getNombre(): String = nombre
    fun getDuracion(): Float = duracion
    fun getImagen(): Int = imagen

}