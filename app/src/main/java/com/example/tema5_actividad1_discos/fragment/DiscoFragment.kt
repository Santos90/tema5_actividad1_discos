package com.example.tema5_actividad1_discos.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tema5_actividad1_discos.POJO.Disco
import com.example.tema5_actividad1_discos.adapter.DiscoAdapter
import com.example.tema5_actividad1_discos.adapter.DiscoListener
import com.example.tema5_actividad1_discos.databinding.FragmentDiscoBinding

class DiscoFragment : Fragment(), DiscoListener {
    private lateinit var binding: FragmentDiscoBinding

    private lateinit var discoAdapter: DiscoAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var itemDecoration: DividerItemDecoration


    private lateinit var listenerDisco: DiscoListener
    private lateinit var disco : Disco
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDiscoBinding.inflate(inflater, container, false)


        discoAdapter = DiscoAdapter(Disco.DiscoDatos.DISCOS, this)
        linearLayoutManager = LinearLayoutManager(context)
        itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.recyclerIdList.apply{
            layoutManager = linearLayoutManager
            adapter = discoAdapter
            addItemDecoration(itemDecoration)
        }

        return binding.root
    }
    fun setFragmentListener(listener: DiscoListener) {
        this.listenerDisco = listener

    }

    override fun seleccionarDisco(disco: Disco) {
        if (listenerDisco != null) listenerDisco.seleccionarDisco(disco)
    }


}