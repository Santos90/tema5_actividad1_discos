package com.example.tema5_actividad1_discos.POJO

import com.example.tema5_actividad1_discos.R

class Disco (private var nombre : String,
             private var grupo : String,
             private  var listaCanciones : ArrayList<Cancion>,
             private var imagen: Int = R.drawable.disco
    ){

    fun getNombre(): String = this.nombre

    fun getGrupo(): String {
        return  this.grupo
    }

    fun getImagen(): Int {
        return  this.imagen
    }

    fun getListaCanciones(): ArrayList<Cancion> = listaCanciones

    class DiscoDatos{
        companion object{
            val CANCIONES = arrayListOf<Cancion> (
                Cancion(1, "Cancion 1", 123.0f ),
                Cancion(2, "Cancion 2", 456.0f ),
                Cancion(3, "Cancion 3", 132.0f ),
                Cancion(4, "Cancion 4", 213.0f ),
                Cancion(5, "Cancion 5", 421.0f ),
                Cancion(6, "Cancion 6", 123.0f ),
            )
            val DISCOS = arrayListOf<Disco>(
                Disco("Disco 1", "Grupo 1", CANCIONES),
                Disco("Disco 2", "Grupo 2", CANCIONES),
                Disco("Disco 3", "Grupo 3", CANCIONES),
                Disco("Disco 4", "Grupo 4", CANCIONES),

            )
        }
    }
}