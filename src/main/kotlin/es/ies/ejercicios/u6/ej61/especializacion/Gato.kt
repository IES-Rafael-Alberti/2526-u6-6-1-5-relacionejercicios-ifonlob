package es.ies.ejercicios.u6.ej61.especializacion

class Gato(nombre : String, edad : Int, val colorPelo : String) : Animal(nombre,edad) {
    fun maullar() {
        println("$nombre maúlla: ¡Miau!")
    }

    override fun hacerSonido() {
        maullar()
    }

    fun trepar(arbol: String) {
        println("$nombre trepa el $arbol.")
    }
}