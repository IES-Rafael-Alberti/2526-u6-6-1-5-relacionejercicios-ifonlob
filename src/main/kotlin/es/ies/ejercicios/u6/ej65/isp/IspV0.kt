
package es.ies.ejercicios.u6.ej65.isp

import es.ies.ejercicios.u6.ej64.Persona




interface  Guardable{
    fun guardar(persona: Persona)
}

interface Buscable{
    fun buscar(nombre: String): Persona?
}

interface Exportable{
    fun exportarCsv(): String
}

interface Borrable{
    fun borrarTodo()
}
class RepositorioMemoriaV1 : Guardable, Buscable, Exportable, Borrable {
    private val map = mutableMapOf<String, Persona>()

    override fun guardar(persona: Persona) {
        map[persona.nombre] = persona
    }

    override fun buscar(nombre: String): Persona? = map[nombre]

    override fun exportarCsv(): String =
        buildString {
            appendLine("nombre,edad")
            for (p in map.values) appendLine("${p.nombre},${p.edad}")
        }

    override fun borrarTodo() {
        map.clear()
    }
}

/**
 * Cliente que solo necesita buscar, pero depende de una interfaz con demasiadas cosas.
 */
class BuscadorPersonasV0(private val repo: Buscable) {
    fun buscar(nombre: String): Persona? = repo.buscar(nombre)
}

class ExportadorCSV(private val repo: Exportable) {
    fun exportar(): String = repo.exportarCsv()
}


fun main() {
    val repo = RepositorioMemoriaV1()
    repo.guardar(Persona("Ana", 20))

    val buscador = BuscadorPersonasV0(repo)
    println("Buscar Ana -> ${buscador.buscar("Ana")?.resumen()}")
}

