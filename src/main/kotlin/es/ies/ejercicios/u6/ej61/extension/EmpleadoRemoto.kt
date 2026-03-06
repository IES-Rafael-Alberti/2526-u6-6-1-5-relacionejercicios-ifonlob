package es.ies.ejercicios.u6.ej61.extension

class EmpleadoRemoto(nombre: String, apellido: String, salarioBase: Double, val horasTeletrabajo: Int) : Empleado(nombre,apellido,salarioBase) {
    fun conectarVPN() {
        println("$nombre se conecta a VPN para trabajar remoto.")
    }

    fun registrarHorasTrabajadas() {
        println("$nombre registra $horasTeletrabajo horas teletrabajadas.")
    }
}