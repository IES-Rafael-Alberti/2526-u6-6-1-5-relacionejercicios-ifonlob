package es.ies.ejercicios.u6.ej64

// Este fichero contiene ejemplos de:
// - herencia (6.1)
// - clase abstracta e interfaces (6.2)
// - constructores e init en herencia (6.3)
//
// Tu tarea (6.4) es:
// - Entender el código y su relación entre clases e interfaces.
// - Mejorar la documentación KDoc donde sea necesario.
// - Añadir comentarios solo cuando aporten valor.
// - Eliminar comentarios innecesarios o redundantes.

/**
 * Representa un elemento que puede generar un resumen en texto.
 *
 * Presenta un método abstracto que permite resumir a las clases que lo implementen.
 *
 */
interface Resumible {
    fun resumen(): String
}

/**
 * Plantilla para generar un informe en distintos formatos.
 *
 * Relación con el resto del ejercicio:
 * - [Persona] y [Alumno] implementan [Resumible] y se pueden incluir como elementos del informe.
 *
 * Nota: el método [generar] está bloqueado (no es `open`) para forzar un flujo común
 * y permitir que las subclases solo personalicen las partes variables.
 */
abstract class PlantillaInforme : Resumible {
    /**
     * Genera el informe a partir de una cabecera, una lista de resumibles y un pie de página.
     *
     * Utiliza la clase StringBuilder para montar el informe.
     *
     * @param titulo El título de la cabecera del informe
     * @param items Lista de objetos que son resumibles
     * @return El informe completo montado con StringBuilder
     */
    fun generar(titulo: String, items: List<Resumible>): String {
        val sb = StringBuilder()

        sb.appendLine(cabecera(titulo))

        for (item in items) {
            sb.appendLine(formatearItem(item))
        }

        sb.appendLine(pie())
        return sb.toString()
    }

    protected open fun cabecera(titulo: String): String = titulo

    protected abstract fun formatearItem(item: Resumible): String

    protected open fun pie(): String = "-- fin --"

    override fun resumen(): String = "PlantillaInforme"
}

/**
 * Formato Markdown para informes: listas con "-"
 */
class InformeMarkdown : PlantillaInforme() {
    override fun cabecera(titulo: String): String = "# $titulo"

    override fun formatearItem(item: Resumible): String = "- ${item.resumen()}"
}
/**
 * Formato CSV para informes: sustitución de  , por ;
 */
class InformeCsv : PlantillaInforme() {
    override fun cabecera(titulo: String): String = "titulo,$titulo\nitem"

    override fun formatearItem(item: Resumible): String = item.resumen().replace(",", ";")
}

/**
 * Representa a la entidad Persona
 *
 * Implementa el método resumible, permitiendo generar un resumen de la Persona
 *
 * @property nombre El nombre de la persona
 * @property edad La edad de la persona
 * @constructor Crea una persona con su nombre y edad
 */
open class Persona(
    val nombre: String,
    val edad: Int,
) : Resumible {
    init {
        println("[Persona:init] nombre=$nombre edad=$edad")
    }

    constructor(nombre: String) : this(nombre, edad = 0) {
        println("[Persona:secondary] constructor(nombre)")
    }

    override fun resumen(): String = "$nombre ($edad)"
}
/**
 * Representa a la entidad Alumno.
 *
 * Sobrescribe el método resumible a partir de la implementación de la clase padre, añadiendo el dato del curso.
 *
 * @property curso El curso en el que se encuentra el alumno
 */
class Alumno : Persona {
    val curso: String

    constructor(nombre: String, edad: Int, curso: String) : super(nombre, edad) {
        this.curso = curso
        println("[Alumno:secondary] nombre=$nombre edad=$edad curso=$curso")
    }

    constructor(nombre: String, curso: String) : this(nombre, edad = 0, curso = curso) {
        println("[Alumno:secondary] constructor(nombre, curso)")
    }

    override fun resumen(): String = "Alumno: ${super.resumen()} curso=$curso"
}

/**
 * Permite registrar personas, normalizar y buscar por nombre.
 *
 * Se normaliza el nombre para evitar registros duplicados por diferencias de espacios o mayúsculas/minúsculas.
 */
class RegistroPersonas {
    private val personasPorNombre = mutableMapOf<String, Persona>()

    /**
     * Registra personas y las añade a un mapa por su clave.
     *
     * La clave se obtiene a partir de la normalización del nombre de la persona
     * @param persona Entidad de tipo Persona a la cual se va a registrar
     * @return Unit
     */
    fun registrar(persona: Persona) {
        val clave = normalizarNombre(persona.nombre)
        personasPorNombre[clave] = persona
    }
    fun buscar(nombre: String): Persona? = personasPorNombre[normalizarNombre(nombre)]

    private fun normalizarNombre(nombre: String): String {
        return nombre.trim().lowercase()
    }
}
