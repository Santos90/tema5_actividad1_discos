package com.example.tema5_actividad1_discos.adapter

import com.example.tema5_actividad1_discos.POJO.Disco

interface DiscoListener {


    fun seleccionarDisco(disco: Disco)//: ArrayList<Cancion>
}