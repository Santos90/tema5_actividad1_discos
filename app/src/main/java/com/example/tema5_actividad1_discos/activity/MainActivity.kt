package com.example.tema5_actividad1_discos.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tema5_actividad1_discos.POJO.Disco
import com.example.tema5_actividad1_discos.R
import com.example.tema5_actividad1_discos.adapter.DiscoListener
import com.example.tema5_actividad1_discos.databinding.ActivityMainBinding
import com.example.tema5_actividad1_discos.fragment.CancionFragment
import com.example.tema5_actividad1_discos.fragment.DiscoFragment

class MainActivity : AppCompatActivity(), DiscoListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentDisco : DiscoFragment
    private lateinit var fragmentCancion : CancionFragment


    private lateinit var discoListener: DiscoListener



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentDisco = DiscoFragment()


        supportFragmentManager
            .beginTransaction()
            .add(R.id.contenedorFragments, fragmentDisco, DiscoFragment::class.java.name).commit()


        fragmentDisco.setFragmentListener(this)
    }

    override fun seleccionarDisco(disco: Disco) {
        fragmentCancion = CancionFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.contenedorFragments, fragmentCancion, CancionFragment::class.java.name)
            .commit()
        //fragmentCancion.setFragmentListener(this)
        Log.i("Canciones", disco.getListaCanciones().toString() )
        fragmentCancion.listarCanciones(disco.getListaCanciones())
    }


}

