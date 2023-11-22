package com.example.tema5_actividad1_discos.activity

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    private var discoSeleccionado : Disco? = null



    private lateinit var discoListener: DiscoListener



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        fragmentDisco = DiscoFragment()
        fragmentDisco.setFragmentListener(this)

        supportFragmentManager
            .beginTransaction()
            .replace(binding.fragDisco.id, fragmentDisco, DiscoFragment::class.java.name)
            .commit()

        //fragmentDisco = supportFragmentManager.findFragmentById(binding.fragDisco!!.id) as DiscoFragment
        if (discoSeleccionado == null) discoSeleccionado= Disco.DiscoDatos.DISCOS[0]

        seleccionarDisco(discoSeleccionado!!)
    }

    override fun seleccionarDisco(disco: Disco) {
        fragmentCancion = CancionFragment()
        discoSeleccionado = disco
        fragmentCancion.setDisco(disco)

        var hayDetalle = supportFragmentManager.findFragmentById(R.id.fragCancion) != null
                && resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

        if (hayDetalle) {//Si existe fragCancion, se muestra el contenido en la misma Activity

            supportFragmentManager
                .beginTransaction()
                .replace(binding.fragCancion!!.id, fragmentCancion)
                .commit()
        } else {

            supportFragmentManager
                .beginTransaction()
                .replace(binding.fragDisco.id, fragmentCancion)
                .addToBackStack("Cancione")
                .commit()
        }
    }


    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }


}

