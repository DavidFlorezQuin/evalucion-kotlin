package com.example.evaluacion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txt = findViewById<EditText>(R.id.txtone)
        val result = findViewById<TextView>(R.id.result)
        val btn = findViewById<Button>(R.id.butonuma)

        fun esPrimo(numero: Int): Boolean {
            if (numero <= 1) return false
            if (numero == 2) return true
            if (numero % 2 == 0) return false
            for (i in 3..Math.sqrt(numero.toDouble()).toInt() step 2) {
                if (numero % i == 0) {
                    return false
                }
            }
            return true
        }

        btn.setOnClickListener {
            val number = txt.text.toString().toIntOrNull()
            if (number != null) {
                val esPrimo = esPrimo(number)
                result.text = if (esPrimo) "Es primo" else "$number no es primo"
            } else {
                result.text = "Por favor, ingresa un número válido."
            }
        }
    }
}