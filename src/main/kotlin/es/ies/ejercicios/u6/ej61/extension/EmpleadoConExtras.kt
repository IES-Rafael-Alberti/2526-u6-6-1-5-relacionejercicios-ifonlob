package es.ies.ejercicios.u6.ej61.extension

class EmpleadoConExtras(nombre: String, apellido: String, salarioBase: Double,val bonus: Double) : Empleado(nombre,apellido,salarioBase) {
    fun solicitarVacaciones(dias : Int){
        println("$nombre $apellido solicita $dias de vacaciones.")
    }

    fun calcularSalarioConBonus() : Double{
        return salarioBase + bonus
    }
}

