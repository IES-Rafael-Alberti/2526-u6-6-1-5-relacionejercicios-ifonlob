package es.ies.ejercicios.u6.ej65.ocp

import es.ies.ejercicios.u6.ej64.Resumible

interface Generable{
    fun generar(titulo: String, items: List<Resumible>)
}

class FormatoMarkdown : Generable{
    override fun generar(titulo: String, items: List<Resumible>) : String {
        buildString {
            appendLine("# $titulo")
            for (item in items) appendLine("- ${item.resumen()}")
        }
    }
}
class FormatoCsv : Generable{
    override fun generar(titulo: String, items: List<Resumible>) : String{
        buildString {
            appendLine("titulo,$titulo")
            appendLine("item")
            for (item in items) appendLine(item.resumen().replace(",", ";"))
        }
    }
}

class GeneradorInformeV1(val generable : Generable) {
    fun generarInforme(titulo: String, items: List<Resumible>){
        generable.generar(titulo, items)
    }
}



fun main() {
    val items = listOf<Resumible>(
        object : Resumible {
            override fun resumen(): String = "Elemento A"
        },
        object : Resumible {
            override fun resumen(): String = "Elemento B"
        },
    )

    val generador = GeneradorInformeV0()
    println(generador.generar(FormatoInformeV0.MARKDOWN, "Demo OCP", items))
}

