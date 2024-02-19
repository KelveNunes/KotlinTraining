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

    val numeroRomano: String? = readLine()

    val numerosRomanos = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
    )

    var resultado = 0

    for (i in numeroRomano!!.indices) {
        // Recupera o valor em romano do indice atual.
        val atual = numerosRomanos.getValue(numeroRomano[i])
        // Recupera o valor em romano do próximo indice (caso exista).
        val proximo = when (i + 1) {
            // Caso o próximo indice não exista, atribui 0 à variável $proximo.
            numeroRomano.length -> 0
            // Caso contrário, atribui o valor em romano equivalente ao próximo indice.
            else -> numerosRomanos.getValue(numeroRomano[i + 1])
        }

        if (proximo<=atual) {
            resultado += atual
        }
        else{
            resultado -= atual
        }
    }

    print(resultado)
}
