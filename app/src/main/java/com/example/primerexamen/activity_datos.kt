package com.example.primerexamen

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.RequiresApi
import com.example.primerexamen.databinding.ActivityDatosBinding
import com.example.primerexamen.databinding.ActivityMainBinding
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class activity_datos : AppCompatActivity() {
    private var resultado: String = ""
    private var DatosJugador:String=""
    private var credito: Double?=null
    private lateinit var binding: ActivityDatosBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatosBinding.inflate((layoutInflater))
        setContentView(binding.root)

        resultado = """
            El jugador gano: ${intent.getStringExtra("texto")} puntos
        """.trimIndent()
        binding.txtResultado.text = resultado

     DatosJugador="""
         Nombre completo: Jasmin Deyna Cabrera Aspiazu
         Jugo en la fecha: ${LocalDateTime.now()}
         El credito es: ${(intent.getStringExtra("texto"))!!.toDouble() + ((intent.getStringExtra("texto"))!!.toDouble() * 0.15) + (LocalDateTime.now().dayOfMonth.toDouble())}
     """.trimIndent()
        binding.txtDatos.text= DatosJugador
    }





}