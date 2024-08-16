package com.example.evaluacion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main7)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etNombre = findViewById<EditText>(R.id.txtNombre)
        val etEdad = findViewById<EditText>(R.id.txtEdad)
        val etCiudad = findViewById<EditText>(R.id.txtCiudad)
        val etIngresos = findViewById<EditText>(R.id.txtIngresos)
        val etEstadoCivil = findViewById<EditText>(R.id.txtEstadoCivil) // Corregido
        val etOcupacion = findViewById<EditText>(R.id.txtOcupacion)
        val btnAgregar = findViewById<Button>(R.id.button)
        val tvResultado = findViewById<TextView>(R.id.result)
        val tableLayout = findViewById<TableLayout>(R.id.tabla)

        btnAgregar.setOnClickListener {
            try {
                val nombre = etNombre.text.toString()
                val edad = etEdad.text.toString().toIntOrNull() ?: 0
                val ciudad = etCiudad.text.toString()
                val ingresos = etIngresos.text.toString().toDoubleOrNull() ?: 0.0
                val estadoCivil = etEstadoCivil.text.toString()
                val ocupacion = etOcupacion.text.toString()

                val usuario = Usuario(nombre, edad, ciudad, ingresos, estadoCivil, ocupacion)
                usuarios.add(usuario)
                mostrarInformacion(tableLayout)
                mostrarResultados(tvResultado)
            } catch (e: Exception) {
                tvResultado.text = "Error: ${e.message}"
            }
        }
    }

    private fun mostrarInformacion(tableLayout: TableLayout) {
        tableLayout.removeAllViews()

        val headerRow = TableRow(this)
        headerRow.addView(createTextView("Nombre"))
        headerRow.addView(createTextView("Edad"))
        headerRow.addView(createTextView("Ciudad"))
        headerRow.addView(createTextView("Ingresos"))
        headerRow.addView(createTextView("Estado Civil"))
        headerRow.addView(createTextView("Ocupación"))
        tableLayout.addView(headerRow)

        for (usuario in usuarios) {
            val row = TableRow(this)
            row.addView(createTextView(usuario.nombre))
            row.addView(createTextView(usuario.edad.toString()))
            row.addView(createTextView(usuario.ciudad))
            row.addView(createTextView(usuario.ingresos.toString()))
            row.addView(createTextView(usuario.estadoCivil))
            row.addView(createTextView(usuario.ocupacion))
            tableLayout.addView(row)
        }
    }

    private fun createTextView(text: String): TextView {
        val textView = TextView(this)
        textView.text = text
        textView.setPadding(8, 8, 8, 8)
        return textView
    }

    private fun mostrarResultados(tvResultado: TextView) {
        if (usuarios.isEmpty()) {
            tvResultado.text = "No hay usuarios registrados."
            return
        }

        val mayorIngreso = usuarios.maxByOrNull { it.ingresos }
        val menorIngreso = usuarios.minByOrNull { it.ingresos }
        val numRegistros = usuarios.size
        val ocupaciones = usuarios.groupBy { it.ocupacion }
        val porcentajeOcupaciones = ocupaciones.map { (ocupacion, lista) ->
            val porcentaje = (lista.size.toDouble() / numRegistros) * 100
            "$ocupacion: %.2f%%".format(porcentaje)
        }.joinToString(", ")

        val resultados = StringBuilder()
        resultados.append("Mayor Ingreso: ${mayorIngreso?.nombre} con ${mayorIngreso?.ingresos}\n")
        resultados.append("Menor Ingreso: ${menorIngreso?.nombre} con ${menorIngreso?.ingresos}\n")
        resultados.append("Número de Registros: $numRegistros\n")
        resultados.append("Porcentaje de Ocupaciones: $porcentajeOcupaciones")

        tvResultado.text = resultados.toString()
    }
}
