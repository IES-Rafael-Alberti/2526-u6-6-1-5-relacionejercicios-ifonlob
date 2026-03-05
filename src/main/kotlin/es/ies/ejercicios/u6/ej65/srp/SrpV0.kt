package es.ies.ejercicios.u6.ej65.srp

import es.ies.ejercicios.u6.ej64.*

/**
 * v0 (mejorable): demasiadas responsabilidades mezcladas:
 * - prepara datos
 * - normaliza y registra personas
 * - genera informe
 * - hace logs
 */
/*
class InformeAppServiceV0 {
    fun ejecutar() {
        println("[SRP:v0] Preparando datos...")
        val items: List<Resumible> = listOf(
            Persona(" Ana ", 20),
            Alumno("Luis", 19, "1DAM"),
            Persona("Marta", 18),
        )

        println("[SRP:v0] Registrando personas...")
        val registro = RegistroPersonas()
        for (item in items) {
            if (item is Persona) registro.registrar(item)
        }

        println("[SRP:v0] Generando informe Markdown...")
        val informe = InformeMarkdown()
        val salida = informe.generar("Listado", items)

        println("[SRP:v0] Resultado:")
        println(salida)

        println("[SRP:v0] Buscar 'ana' -> ${registro.buscar("ana")?.resumen()}")
    }
}
*/

class RecopiladorDatos() {
    fun obtenerDatos(): List<Resumible> {
        return listOf(
            Persona(" Ana ", 20),
            Alumno("Luis", 19, "1DAM"),
            Persona("Marta", 18)
        )

    }
}
class InformeAppServiceV1(private val recopiladorDatos: RecopiladorDatos, private val registroPersonas: RegistroPersonas, private val plantillaInforme: PlantillaInforme){
    fun ejecutar(){
        val items = recopiladorDatos.obtenerDatos()
        items.forEach{ item ->
               if (item is Persona) registroPersonas.registrar(item)
            }
        val salida = plantillaInforme.generar("Listado", items)
        print(salida)
    }
}


fun main() {
    val recopilador = RecopiladorDatos()
    val registro = RegistroPersonas()
    val plantillaMarkdown = InformeMarkdown()
    val appService = InformeAppServiceV1(recopilador, registro, plantillaMarkdown)
    appService.ejecutar()
}


