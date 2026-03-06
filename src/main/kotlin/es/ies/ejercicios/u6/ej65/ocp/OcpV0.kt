package es.ies.ejercicios.u6.ej65.ocp

import es.ies.ejercicios.u6.ej64.Resumible

interface Generable{
    fun generar(titulo: String, items: List<Resumible>) : String
}

class FormatoMarkdown : Generable{
    override fun generar(titulo: String, items: List<Resumible>) : String {
        val informe = buildString {
            appendLine("# $titulo")
            for (item in items) appendLine("- ${item.resumen()}")
        }
        return informe
    }
}
class FormatoCsv : Generable{
    override fun generar(titulo: String, items: List<Resumible>) : String{
        val informe = buildString {
            appendLine("titulo,$titulo")
            appendLine("item")
            for (item in items) appendLine(item.resumen().replace(",", ";"))
        }
        return informe
    }
}

class GeneradorInformeV1(val generable : Generable) {
    fun generarInforme(titulo: String, items: List<Resumible>) : String{
        val informe = generable.generar(titulo, items)
        return informe
    }
}



fun main() {
    val items = listOf<Resumible>(
        object : Resumible {
            override fun resumen(): String = "Elemento A"
        },
        object : Resumible {
            override fun resumen(): String = "Elemento B"
        }
    )

    println("=== Prueba Formato Markdown ===")
    val formatoMarkdown = FormatoMarkdown()
    val generadorMarkdown = GeneradorInformeV1(formatoMarkdown)
    val informeMarkdown = generadorMarkdown.generarInforme("Prueba", items)
    println(informeMarkdown)

    println("\n=== Prueba Formato CSV ===")
    val formatoCsv = FormatoCsv()
    val generadorCsv = GeneradorInformeV1(formatoCsv)
    val informeCsv = generadorCsv.generarInforme("Prueba", items)
    println(informeCsv)
}

