package com.bullon.carlos.usolayoutsv4

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bullon.carlos.usolayoutsv4.databinding.ActivityEjercicio01Binding

class MainActivity : AppCompatActivity() {

    // Inicializar ViewBinding
    private lateinit var binding: ActivityEjercicio01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflar el layout con ViewBinding
        binding = ActivityEjercicio01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mostrar el área verde
        binding.btnMostrar.setOnClickListener {
            binding.greenArea.visibility = View.VISIBLE
        }

        // Ocultar el área verde
        binding.btnOcultar.setOnClickListener {
            binding.greenArea.visibility = View.GONE
        }
    }
}
