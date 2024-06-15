package com.example.calculaimc_4

import org.junit.Test

import org.junit.Assert.*
import java.util.Locale

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun imc_correct() {
        val imc = MainActivity.Calculo()
        if (Locale.getDefault().language.equals("en")) {
            assertTrue( "BMC calculated: ", imc.calculaIMC(176.37, 5.905 ) in 24.6 .. 24.7 )
        }
        else {
            assertTrue( "IMC calculado: ", imc.calculaIMC( 80.0, 1.80 ) in 24.6 .. 24.7 )
        }

    }
}