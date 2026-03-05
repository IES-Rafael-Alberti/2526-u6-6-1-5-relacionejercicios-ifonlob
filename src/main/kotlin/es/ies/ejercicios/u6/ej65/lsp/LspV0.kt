package es.ies.ejercicios.u6.ej65.lsp

import es.ies.ejercicios.u6.ej64.Persona

/**
 * Contrato: un repositorio que permite guardar y buscar personas.
 */

interface Guardable{
    fun guardar(persona: Persona)
}

interface Buscable {
    fun buscar(nombre: String) : Persona?
}
open class RepositorioPersonasV1: Buscable, Guardable {
    private val map = mutableMapOf<String, Persona>()

    override fun guardar(persona: Persona) {
        map[persona.nombre] = persona
    }

    override fun buscar(nombre: String): Persona? = map[nombre]
}

class RepositorioSoloLecturaV1(private val map : Map<String, Persona>) : Buscable {
    override fun buscar(nombre: String): Persona? = map[nombre]
}

fun clienteBuscador(repo: Buscable) {
    println("Buscar Ana -> ${repo.buscar("Ana")?.resumen()}")
}

fun clienteEscritor(repo: Guardable) {
    repo.guardar(Persona("Ana", 20))
    println("Ana ha sido guardada.")
}

fun main() {
    val repoCompleto = RepositorioPersonasV1()
    clienteEscritor(repoCompleto)
    clienteBuscador(repoCompleto)

    val datosPreexistentes = mapOf("Ana" to Persona("Ana", 20))
    val repoLectura = RepositorioSoloLecturaV1(datosPreexistentes)

    clienteBuscador(repoLectura)
}
