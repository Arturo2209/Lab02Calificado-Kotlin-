package com.bullon.carlos.usolayoutsv4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bullon.carlos.usolayoutsv4.databinding.ActivityDetallesPedidoBinding

class DetallesPedidoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetallesPedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallesPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombre = intent.getStringExtra("nombre")
        val numero = intent.getStringExtra("numero")
        val productos = intent.getStringExtra("productos")
        val direccion = intent.getStringExtra("direccion")

        binding.tvNombre.text = nombre
        binding.tvNumero.text = numero
        binding.tvProductos.text = productos
        binding.tvDireccion.text = direccion

        binding.btnLlamar.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$numero")
            startActivity(intent)
        }

        binding.btnWhatsapp.setOnClickListener {
            val mensaje = "Hola $nombre, tus productos: $productos están en camino a la dirección: $direccion"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$numero&text=$mensaje")
            startActivity(intent)
        }

        binding.btnMaps.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=$direccion"))
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }
    }
}
