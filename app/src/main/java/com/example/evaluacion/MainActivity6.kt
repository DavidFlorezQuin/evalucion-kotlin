package com.example.evaluacion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main6)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txt = findViewById<EditText>(R.id.txtone);
        val result = findViewById<TextView>(R.id.result);
        val btn = findViewById<Button>(R.id.butonuma);

        val lista = mutableListOf<String>()

            btn.setOnClickListener {
                val text = txt.text

                val elementos = text.split(",").map { it.trim() }
                lista.addAll(elementos)

                val listaTexto = lista.joinToString(separator = ",")
                result.text = "Elementos de la lista:$listaTexto"
            }

        }}
