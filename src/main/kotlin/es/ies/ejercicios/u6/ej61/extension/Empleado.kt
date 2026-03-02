package es.ies.ejercicios.u6.ej61.extension

open class Empleado(val nombre : String, val apellido : String, val salarioBase : Double) {
    fun trabajar() {
        println("$nombre $apellido está trabajando.")
    }

    fun calcularSalario(): Double {
        return salarioBase
    }
}