package es.ies.ejercicios.u6.ej61.especializacion

fun main(){
    val animal1: Animal = Perro("Leo", 3, "Labrador")
    val animal2: Animal = Gato("Michi", 2, "Siamés")

    println("1.COMER:")
    animal1.comer(500)
    animal2.comer(200)

    println("2. HACER SONIDO:")
    animal1.hacerSonido()
    animal2.hacerSonido()

    println("3. MOVERSE:")
    animal1.moverse()
    animal2.moverse()

    println("MÉTODOS ESPECÍFICOS")
    (animal1 as Perro).jugar("pelota")
    (animal2 as Gato).trepar("pino")
}