package com.curso.android.app.prectica.proyectofinalmjm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.curso.android.app.prectica.proyectofinalmjm.R
import com.curso.android.app.prectica.proyectofinalmjm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   private  lateinit var binding: ActivityMainBinding
   private val mainViewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.comparacion.observe(this){
            binding.tvResultado.text="${it.resultado}"
        }

        binding.btnComparar.setOnClickListener {
            val texto1=binding.et1.text.toString()
            val texto2=binding.et2.text.toString()
            mainViewModel.compara(texto1,texto2)
        }

    }
}