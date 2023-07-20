package com.example.ejercicio16listapais

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ejercicio16listapais.databinding.ItemBinding

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    var paises = mutableListOf<Pais>()
    var callback: PaisCallBack? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return paises.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pais = paises[position]
        holder.bind(pais)
    }

    fun setData(paises: MutableList<Pais>) {
        this.paises = paises.toMutableList()
    }

    inner class ViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(pais: Pais) {
            binding.nombrePais.text = pais.nombre
            binding.bandera.load(pais.imgUrl)

            val text = "Poblacion actual de ${pais.nombre} ${pais.poblacion} de personas"

            binding.cView.setOnClickListener(View.OnClickListener {

                callback?.showCountry(text)
            })

        }

    }

    interface PaisCallBack {
        fun showCountry(s: String)

    }


}