package es.ies.ejercicios.u6.ej62

fun main() {
    val lines = listOf("Primera línea", "Segunda línea", "Tercera línea")

    val csv = CsvReport()
    println("--- CSV ---")
    println(csv.generate("Informe CSV", lines))

    val md = MarkdownReport()
    println("--- MARKDOWN ---")
    println(md.generate("Informe MD", lines))

    val logger = StdoutLogger()
    logger.log("Log de prueba")
}
