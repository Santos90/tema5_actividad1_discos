package com.example.tema5_actividad1_discos.adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.tema5_actividad1_discos.POJO.Disco
import com.example.tema5_actividad1_discos.R
import com.example.tema5_actividad1_discos.databinding.ItemBinding

// ... (imports y otras declaraciones)

class DiscoAdapter(private val lista: List<Disco>, private val listener: DiscoListener) :
    RecyclerView.Adapter<DiscoAdapter.ViewHolder>() {

    private var selectedItem = RecyclerView.NO_POSITION

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemBinding.bind(view) // Vinculamos la vista a nuestro adapter

        fun setListener(item: Disco) {
            binding.root.setOnClickListener {
                listener.seleccionarDisco(item)
                setSelectedItem(adapterPosition)
            }

            // Configurar el estado seleccionado basado en la posición
            binding.root.isSelected = adapterPosition == selectedItem
        }
    }

    private lateinit var context: Context

    // El layout manager invoca este método para renderizar cada elemento del RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = lista[position]

        with(holder) {
            setListener(item)
            binding.lblTitulo.text = item.getNombre()
            binding.lblSubtitulo.text = item.getGrupo()
        }

        Glide.with(context)
            .load(item.getImagen())
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(holder.binding.imagen)
    }

    // Este método devolverá el tamaño de la lista
    override fun getItemCount(): Int = lista.size

    // Método para actualizar el elemento seleccionado
    private fun setSelectedItem(position: Int) {
        val previousSelectedItem = selectedItem
        selectedItem = position

        // Notificar cambios solo en los elementos afectados
        notifyItemChanged(previousSelectedItem)
        notifyItemChanged(selectedItem)
    }
}
