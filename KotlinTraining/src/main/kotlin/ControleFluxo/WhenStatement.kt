package ControleFluxo

import Functions.multiply

class whenExpression {
}
fun whenAssing(numero: Int, numero2: Int) : Any{
    var mutiply = multiply(numero,numero2)
    var result = when(mutiply){
        2 -> "dois"
        4 -> "quatro"
        6 -> "seis"
        else -> "Nenhum dos resultados"
    }
    return result
}
fun main(){
    println(whenAssing(2,1))
}

