package com.example.evaluacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var bto1 = findViewById<Button>(R.id.button1);
        var bto2 = findViewById<Button>(R.id.button2);
        var bto3 = findViewById<Button>(R.id.button3);
        var bto4 = findViewById<Button>(R.id.button4);
        var bto5 = findViewById<Button>(R.id.button5);
        var bto6 = findViewById<Button>(R.id.button6);



        bto1.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

        bto2.setOnClickListener {
            val intent = Intent(this,MainActivity3::class.java)
            startActivity(intent)
        }
        bto3.setOnClickListener {
            val intent = Intent(this,MainActivity4::class.java)
            startActivity(intent)
        }
        bto4.setOnClickListener {
            val intent = Intent(this,MainActivity5::class.java)
            startActivity(intent)
        }
        bto5.setOnClickListener {
            val intent = Intent(this,MainActivity6::class.java)
            startActivity(intent)
        }
        bto6.setOnClickListener {
            val intent = Intent(this,MainActivity7::class.java)
            startActivity(intent)
        }
    }
}