package es.ies.ejercicios.u6.ej61.especializacion

class Perro(nombre : String, edad : Int, val raza : String) : Animal(nombre,edad){
    fun ladrar(){
        println("$nombre ladra: ¡Guau guau!")
    }

    override fun hacerSonido() {
        ladrar()
    }

    fun jugar(juguete : String){
        println("$nombre está jugando con $juguete")
    }
}