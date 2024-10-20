package com.bullon.carlos.usolayoutsv4

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bullon.carlos.usolayoutsv4.databinding.ActivityEjercicio02Binding

class Ejercicio02 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrar.setOnClickListener {
            val nombre = binding.inputNombre.text.toString()
            val numero = binding.inputNumero.text.toString()
            val productos = binding.inputProductos.text.toString()
            val direccion = binding.inputDireccion.text.toString()

            if (nombre.isEmpty() || numero.isEmpty() || productos.isEmpty() || direccion.isEmpty()) {
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, DetallesPedidoActivity::class.java)
                intent.putExtra("nombre", nombre)
                intent.putExtra("numero", numero)
                intent.putExtra("productos", productos)
                intent.putExtra("direccion", direccion)
                startActivity(intent)
            }
        }
    }
}
