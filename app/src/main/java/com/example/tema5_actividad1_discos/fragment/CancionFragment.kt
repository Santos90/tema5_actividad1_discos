package com.example.tema5_actividad1_discos.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tema5_actividad1_discos.POJO.Cancion
import com.example.tema5_actividad1_discos.POJO.Disco
import com.example.tema5_actividad1_discos.adapter.CancionAdapter
import com.example.tema5_actividad1_discos.adapter.CancionListener
import com.example.tema5_actividad1_discos.databinding.FragmentCancionBinding

class CancionFragment : Fragment(), CancionListener {
    private lateinit var binding: FragmentCancionBinding

    private lateinit var cancionAdapter: CancionAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var itemDecoration: DividerItemDecoration

    private lateinit var listenerCancion: CancionListener

    private var listaCanciones = ArrayList<Cancion>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("Canciones Fragment", listaCanciones.toString() )

        binding = FragmentCancionBinding.inflate(inflater, container, false)

        cancionAdapter = CancionAdapter(listaCanciones, this)
        linearLayoutManager = LinearLayoutManager(context)
        itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.recyclerIdList.apply {
            layoutManager = linearLayoutManager
            adapter = cancionAdapter
            addItemDecoration(itemDecoration)
        }

        return binding.root
    }

    // Creamos un método público que nos ayude a asignar el contenido del fragment
    fun setDisco(disco: Disco) {
        listaCanciones = disco.getListaCanciones()
    }

    override fun seleccionarCancion(cancion: Cancion) {
        Toast.makeText(context, "Cancion: ${cancion.getNombre()}", Toast.LENGTH_LONG).show()
    }
}