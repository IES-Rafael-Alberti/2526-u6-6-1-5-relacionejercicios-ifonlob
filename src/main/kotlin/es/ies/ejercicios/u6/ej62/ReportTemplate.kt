package es.ies.ejercicios.u6.ej62

/**
 * Plantilla (para el alumnado): usa clase abstracta + "Template Method".
 *
 * Objetivo didáctico:
 * - Forzar herencia/implementación: `abstract` + miembro `abstract`.
 * - Bloquear sobrescritura del algoritmo: método `final` (o no-`open`).
 */
abstract class ReportTemplate {
    final fun generate(title: String, lines: List<String>): String {
        val resultado = buildString {
            append(header(title))
            for (line in lines) {
                appendLine(formatLine(line))
            }
            append(footer())
        }
        println("Generación completada")
        return resultado
    }



    protected open fun header(title: String): String = "=== $title ===\n"

    protected abstract fun formatLine(line: String): String

    protected open fun footer(): String = "--- Fin informe ---"
}
