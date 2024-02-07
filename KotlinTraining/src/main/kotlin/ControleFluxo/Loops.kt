package ControleFluxo

class Loops {
        fun loops(){
            for(i in 0..3){
                var resultados = WhenStatement().whenAssing(i,i+1)
                println(resultados)
            }
        }

}

fun main(){
    println(Loops().loops())
}
