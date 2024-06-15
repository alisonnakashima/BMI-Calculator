package com.example.calculaimc_4
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var etPeso : EditText
    private lateinit var etAltura : EditText
    private lateinit var tvResultado : TextView
    private lateinit var btCalcular : Button
    private lateinit var btLimpar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPeso = findViewById( R.id.etPeso )
        etAltura = findViewById( R.id.etAltura )
        tvResultado = findViewById( R.id.tvResultado )
        btCalcular = findViewById( R.id.btCalcular )
        btLimpar = findViewById( R.id.btLimpar )

        btCalcular.setOnClickListener {
            btCalcularOnClick()
        }

        btLimpar.setOnClickListener {
            btLimparOnClick()
        }



    }

    private fun btLimparOnClick() {
        etPeso.setText( "" )
        etAltura.setText( "" )
        tvResultado.text = "0.0"
        etPeso.requestFocus()
        Toast.makeText( this, "Tela reiniciada", Toast.LENGTH_LONG ).show()
    }

    private fun btCalcularOnClick() {

        if ( etPeso.text.toString().isEmpty() ) {
            etPeso.error = "Campo Peso deve ser preenchido"
            etPeso.requestFocus()
            return
        }


        if ( etAltura.text.toString().isEmpty() ) {
            etAltura.error = "Campo Altura deve ser preenchido"
            etAltura.requestFocus()
            return
        }

        val peso = etPeso.text.toString().toDouble()
        val altura = etAltura.text.toString().toDouble()

        val imc = peso / altura.pow( 2 )

        tvResultado.text = "%.2f".format( imc )

    }
}