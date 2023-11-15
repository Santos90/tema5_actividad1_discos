package com.example.tema5_actividad1_discos.adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.tema5_actividad1_discos.POJO.Cancion
import com.example.tema5_actividad1_discos.R
import com.example.tema5_actividad1_discos.databinding.ItemBinding


class CancionAdapter (private val lista: List<Cancion>, private val listener: CancionListener):
    RecyclerView.Adapter<CancionAdapter.ViewHolder>(){

    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val binding = ItemBinding.bind(view) //Vinculamos la vista a nuestro adapter

        fun setListener(item :Cancion){
            binding.root.setOnClickListener {listener.onClick(item)}
        }

    }

    private lateinit var context: Context

    // El layout manager invoca este método para renderizar cada elemento del RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { //Inflar la vista item_tarea en el Recycler
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) { //Asignamos el contenido a cada item del Layout Item.xml
        val item = lista.get(position)

        with(holder){
            setListener(item)
            binding.lblTitulo.text = item.getNombre()
            binding.lblSubtitulo.text = item.getDuracion().toString()

        }

        Glide.with(context)
            .load(item.getImagen())
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(holder.binding.imagen)

    }

    // Este método devolverá el tamaño de la lista
    override fun getItemCount(): Int = lista.size



}