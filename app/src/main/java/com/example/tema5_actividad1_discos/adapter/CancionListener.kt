package com.example.tema5_actividad1_discos.adapter

import com.example.tema5_actividad1_discos.POJO.Cancion
import com.example.tema5_actividad1_discos.POJO.Disco

interface CancionListener {
    fun onClick(cancion: Cancion)
}