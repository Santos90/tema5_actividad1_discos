package com.example.tema5_actividad1_discos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.tema5_actividad1_discos.POJO.Cancion
import com.example.tema5_actividad1_discos.POJO.Disco
import com.example.tema5_actividad1_discos.adapter.CancionListener
import com.example.tema5_actividad1_discos.adapter.DiscoListener
import com.example.tema5_actividad1_discos.databinding.ActivityMainBinding
import com.example.tema5_actividad1_discos.fragment.CancionFragment
import com.example.tema5_actividad1_discos.fragment.DiscoFragment

class MainActivity : AppCompatActivity(), DiscoListener, CancionListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentDisco : DiscoFragment
    private lateinit var fragmentCancion : CancionFragment

    private lateinit var activeFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentDisco = DiscoFragment()
        fragmentCancion = CancionFragment()

        //Inicializamos el fragment Activo como el fragmentRed
        activeFragment = fragmentDisco

        supportFragmentManager.beginTransaction()
            .add(R.id.contenedorFragments, fragmentCancion, CancionFragment::class.java.name)
            .hide(fragmentCancion).commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.contenedorFragments, fragmentDisco, DiscoFragment::class.java.name).commit()

    }


    override fun onClick(disco: Disco) {
        fragmentCancion.listarCanciones(disco.getListaCanciones())
    }

    override fun onClick(cancion: Cancion) {
        TODO("Not yet implemented")
    }


}

