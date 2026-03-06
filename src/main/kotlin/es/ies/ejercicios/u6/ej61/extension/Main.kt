package es.ies.ejercicios.u6.ej61.extension

fun main() {
    val empleado1: Empleado = EmpleadoRemoto("Ana", "López", 1800.0, 20)
    val empleado2: Empleado = EmpleadoConExtras("Luis", "García", 2000.0, 250.0)

    println("1. TRABAJAR:")
    empleado1.trabajar()
    empleado2.trabajar()

    println("2. CALCULAR SALARIO BASE:")
    println("${empleado1.nombre} cobra de base: ${empleado1.calcularSalario()}")
    println("${empleado2.nombre} cobra de base: ${empleado2.calcularSalario()}")

    println("3. MÉTODOS ESPECÍFICOS:")
    (empleado1 as EmpleadoRemoto).conectarVPN()
    empleado1.registrarHorasTrabajadas()

    (empleado2 as EmpleadoConExtras).solicitarVacaciones(10)
    println("${empleado2.nombre} con bonus cobra: ${empleado2.calcularSalarioConBonus()}")
}

