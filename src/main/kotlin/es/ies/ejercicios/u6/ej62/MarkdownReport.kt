package es.ies.ejercicios.u6.ej62

class MarkdownReport : ReportTemplate() {
    override fun header(title: String): String {
        return "# $title"
    }

    override fun formatLine(line: String): String = "- $line"
}
