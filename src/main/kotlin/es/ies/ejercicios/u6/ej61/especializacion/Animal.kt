package es.ies.ejercicios.u6.ej61.especializacion

open class Animal(val nombre : String, val edad : Int) {
    fun comer(cantidad : Int){
        println("$nombre está comiendo $cantidad gramos de comida.")
    }

    open fun hacerSonido(){
        println("$nombre hace un sonido.")
    }

    fun moverse(){
         println("$nombre se está moviendo.")
    }
}