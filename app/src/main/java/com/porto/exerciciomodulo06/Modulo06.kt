package com.porto.exerciciomodulo06

class Modulo06 {
}
fun main() {

val factory = VeiculoFactory()
val veiculoList: MutableList<Veiculo> = mutableListOf()
    for(i in 1 ..4){
        val veiculo = factory.createVeiculo(i % 2)
        veiculoList.add(veiculo)
    }
    veiculoList.forEach{
        veiculo ->
        veiculo.addSpeed(0)
        veiculo.print()
    }
}
class VeiculoFactory{
 fun createVeiculo(type: Int): Veiculo {
    return when(type){
        1-> Moto()
        else -> Carro()
    }
 }
}
 interface  Veiculo{

     var velocity: Long
     var acceleration: Long
     var model: String


    fun addSpeed( increaseSpeed: Long ): Long{
        velocity +=  acceleration + increaseSpeed
       // println("Mètodo 1\nA Velocidade atual é $velocity KM")

        return velocity
    }

    fun reduceSpeed(slowDown: Long) : Long{
        velocity -=  slowDown - acceleration

        if (velocity < 0  )
            velocity = 0

        println("Mètodo 2\nA Velocidade atual é $velocity KM")
        return velocity
    }

    fun print(){
        println(" Modelo: $model \n Velocidade: $velocity \n Aceleração: $acceleration ")
    }
    fun printVelocity(){
        println("Mètodo 3 \n Velocidade: $velocity KM atual!")
    }


}
class Carro: Veiculo {
    override var velocity: Long = 0
    override var acceleration: Long = 10
    override var model: String = "UNO"

    override fun toString()= " Modelo: $model  Velocidade: $velocity  Aceleração: $acceleration "
}
 class Moto  : Veiculo{
     override var velocity: Long = 5
     override var acceleration: Long = 10
     override var model: String = "MT09"

     override fun toString()= " Modelo: $model  Velocidade: $velocity  Aceleração: $acceleration "
 }


