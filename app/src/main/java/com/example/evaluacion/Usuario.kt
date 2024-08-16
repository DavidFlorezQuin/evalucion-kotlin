package com.example.evaluacion

data class Usuario(
    val nombre: String,
    val edad: Int,
    val ciudad: String,
    val ingresos: Double,
    val estadoCivil: String,
    val ocupacion: String
)
val usuarios = mutableListOf<Usuario>()
