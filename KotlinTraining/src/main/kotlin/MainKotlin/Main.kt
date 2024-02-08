package MainKotlin

import ControleFluxo.Loops
import ControleFluxo.WhenStatement
import Functions.*
import ObjectOrientation.Dog
import ObjectOrientation.Yorkshire

fun main() {
    println("Hello World!")

    println(Loops().loops())//teste da classe loops

    println(WhenStatement().whenAssing(2,1))//teste da função when

    val dog : Dog = Yorkshire()//teste de herança
    dog.SayHello()

    var nullTeste = null//retorno de objetos nulos e tratamento

    nullVar(nullTeste)

    printAllWithPrefix(//treinamento de funções
            "kelve",
            "junior",
            prefix = "greting: ",
    )

    printALL("kelve", "junior")
    printMessage("Hello") // 5
    printMessageWithPrefix("Hello", "Log") // 6
    printMessageWithPrefix("Hello") // 7
    printMessageWithPrefix(prefix = "Log", message = "Hello") // 8
    println(sum(1, 2)) // 9
    println(multiply(2, 4)) // 10
}
