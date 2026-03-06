package es.ies.ejercicios.u6.ej63

fun main() {
    println("==== FIGURA ====")
    println("1. Figura con constructor primario:")
    val f1 = Figura(color = "Rojo", etiqueta = "mi-figura")

    println("\n 2. Figura con constructor secundario (solo color):")
    val f2 = Figura(color = "Azul")


    println("\n\n==== RECTÁNGULO ====")
    println(" 1. Rectángulo con constructor primario:")
    val r1 = Rectangulo(color = "Verde", etiqueta = "mi-rectangulo", ancho = 10, alto = 20)

    println("\n 2. Rectángulo con constructor secundario (ancho, alto):")
    val r2 = Rectangulo(ancho = 5, alto = 8)

    println("\n 3. Rectángulo con constructor secundario (lado/cuadrado):")
    val r3 = Rectangulo(lado = 4)


    println("\n\n==== CÍRCULO ====")
    println(" 1. Círculo con constructor secundario (solo radio):")
    val c1 = Circulo(radio = 7)


    println("\n\n==== TRIÁNGULO (Sin constructor primario) ====")
    println(" 1. Triángulo con constructor secundario (base, altura) -> delega a super():")
    val t1 = Triangulo(base = 3, altura = 4)

    println("\n 2. Triángulo con constructor secundario (lado) -> delega a this() -> delega a super():")
    val t2 = Triangulo(lado = 5)
}