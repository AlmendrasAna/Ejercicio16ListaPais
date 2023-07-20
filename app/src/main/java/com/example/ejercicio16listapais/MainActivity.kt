package com.example.ejercicio16listapais

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio16listapais.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() ,Adapter.PaisCallBack{
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
    }

    fun initAdapter(){
        val adapter =Adapter()
        adapter.setData(PaisesLatam.paises)
        adapter.callback = this
        binding.recyclerView.adapter =adapter

    }



    override fun showCountry(s: String) {
        binding.poblacionTxt.text = s
    }
}