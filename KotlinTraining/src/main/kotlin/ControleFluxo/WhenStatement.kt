package ControleFluxo

import Functions.multiply

class WhenStatement {
    fun whenAssing(numero: Int, numero2: Int) : Any{

        var mutiply = multiply(numero,numero2)
        var result = when(mutiply){ //O when se comporta igual o switch case em java
            2 -> "dois"
            4 -> "quatro"
            6 -> "seis"
            else -> "Nenhum dos resultados"
        }
        return result
    }
}



fun main(){
    println(WhenStatement().whenAssing(2,1))

}