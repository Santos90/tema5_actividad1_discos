package com.example.tema5_actividad1_discos.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tema5_actividad1_discos.POJO.Cancion
import com.example.tema5_actividad1_discos.adapter.CancionAdapter
import com.example.tema5_actividad1_discos.adapter.CancionListener
import com.example.tema5_actividad1_discos.databinding.FragmentCancionBinding

class CancionFragment : Fragment(), CancionListener {
    private lateinit var binding: FragmentCancionBinding
    private lateinit var cancionAdapter: CancionAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var itemDecoration: DividerItemDecoration


    private lateinit var listenerCancion: CancionListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCancionBinding.inflate(inflater, container, false)

        return binding.root
    }

    fun setFragmentListener(listener: CancionListener) {
        this.listenerCancion = listener

    }

    // Creamos un método público que nos ayude a asignar el contenido del fragment
    fun listarCanciones(lista: ArrayList<Cancion>) {

        cancionAdapter = CancionAdapter(lista, this)
        linearLayoutManager = LinearLayoutManager(context)
        itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.recyclerIdList.apply{
            layoutManager = linearLayoutManager
            adapter = cancionAdapter
            addItemDecoration(itemDecoration)
        }
    }

    override fun onClick(cancion: Cancion) {
        TODO("Not yet implemented")
    }
}