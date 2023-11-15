package com.example.tema5_actividad1_discos.adapter

import com.example.tema5_actividad1_discos.POJO.Cancion

interface CancionListener {
    fun seleccionarCancion(cancion: Cancion)
}