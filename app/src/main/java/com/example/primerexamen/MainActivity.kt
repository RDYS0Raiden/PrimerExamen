package com.example.primerexamen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.example.primerexamen.databinding.ActivityMainBinding
import java.util.Date

class MainActivity : AppCompatActivity() {
    private val WHAT_CODE = 8070
    private lateinit var binding: ActivityMainBinding
    private var handler: Handler?= null
    private var mensaje: Message?= null
    private var datos: Bundle ?= null
    private var numeros: List<Int> = listOf(0, 0, 1, 1, 2, 3, 5, 8 ,13, 21)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)

        handler = Handler(mainLooper)
        {
            if (mensaje!!.data.getInt("Bandera") == 1)
                pasarPantalla()
            true
        }
        binding.btnPlay.setOnClickListener {
            GenerarValor()
            VerificarGanar()
            Cargar()
        }
    }
    private fun Cargar() {
        Thread{
            for(i in 0 .. 10)
            {
                try{
                    Thread.sleep(1000)
                }
                catch (e: InterruptedException)
                {
                    e.printStackTrace()
                }
                handler!!.post{
                    binding.apply {
                        txtPorcentaje.text = "$i %"
                        BarraProgreso.progress = i
                    }
                }
            }
            PasarMensajes()
        }.start()
    }
    private fun PasarMensajes() {
        mensaje = Message()
        datos = Bundle()
        datos!!.putInt("Bandera", 1)
        mensaje!!.data = datos
        handler!!.sendMessage(
            handler!!.obtainMessage(WHAT_CODE, mensaje)
        )
    }

    private fun GenerarValor(){
        var valorPc: Int =(numeros).random()
        binding.ValorCompu.text= valorPc.toString()

    }

    private fun pasarPantalla()
    {
        val intent = Intent(this, activity_datos::class.java).apply {
            putExtra("texto", " ${binding.EditTextvalor1.text}")
        }

        startActivity(intent)
    }

    private fun VerificarGanar(){
        if(binding.EditTextvalor1.text contentEquals binding.ValorCompu.text){
            binding.resul.text="GANASTE"

        }
        else{
            binding.resul.text="PERDISTE"
        }
    }

}