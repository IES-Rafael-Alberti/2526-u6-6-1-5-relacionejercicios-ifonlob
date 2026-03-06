package es.ies.ejercicios.u6.ej65.dip

import es.ies.ejercicios.u6.ej64.*

/**
 * v0 (viola DIP): un módulo de alto nivel depende de un detalle concreto: [InformeCsv].
 * El ejercicio consiste en introducir una abstracción e inyectar dependencias.
 */

class ControladorInformes(val generador : PlantillaInforme){
    fun imprimirListado(items: List<Resumible>) {
        val salida = generador.generar("Listado DIP", items)
        println(salida)
    }
}

fun main() {
    val controller = ControladorInformes(InformeCsv())
    controller.imprimirListado(
        listOf(
            Persona("Ana", 20),
            Persona("Luis", 19),
        ),
    )
}

