package com.example.calculaimc_4
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.Locale
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
        tvResultado.text = getString(R.string.zeros)
        etPeso.requestFocus()
        Toast.makeText( this, getString(R.string.toast_limpar), Toast.LENGTH_LONG ).show()
    }

    private fun btCalcularOnClick() {

        if ( etPeso.text.toString().isEmpty() ) {
            etPeso.error =getString(R.string.erro_peso)
            etPeso.requestFocus()
            return
        }

        if ( etAltura.text.toString().isEmpty() ) {
            etAltura.error = getString(R.string.erro_altura)
            etAltura.requestFocus()
            return
        }

        val peso = etPeso.text.toString().toDouble()
        val altura = etAltura.text.toString().toDouble()

        val imc = Calculo()
        val aux = imc.calculaIMC(peso, altura)
        tvResultado.text = "%.2f".format(aux)

   }

    class Calculo {
        fun calculaIMC (peso: Double, altura: Double): Double {

            var imc = 0.0

            if (Locale.getDefault().language.equals("en")) {
                val nf = NumberFormat.getNumberInstance(Locale.US)
                imc = (peso / 2.20463) / ((altura / 3.28084) * (altura / 3.28084))
                imc = nf.format(imc).toDouble()
            } else {
                val nf = NumberFormat.getNumberInstance(Locale.US)
                imc = peso / altura.pow(2)
                imc = nf.format(imc).toDouble()
            }
            return imc
        }
    }
}