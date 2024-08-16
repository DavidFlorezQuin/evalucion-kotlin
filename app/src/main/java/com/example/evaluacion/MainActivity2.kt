package com.example.evaluacion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var num1 = findViewById<EditText>(R.id.txtone);
        var num2 = findViewById<EditText>(R.id.txttwo);
        var btnSum = findViewById<Button>(R.id.butonuma);
        var result = findViewById<TextView>(R.id.result);


        btnSum.setOnClickListener {
            val number1 = num1.text.toString().toIntOrNull() ?: 0
            val number2 = num2.text.toString().toIntOrNull() ?: 0

            var suma = number2 + number1;

            result.text = suma.toString()
        }
    }
}