

fun printMessage(message: String) { // 1
    println(message)
}

fun printMessageWithPrefix(message: String, prefix: String = "Info") { // 2
    println("[$prefix] $message")
}

fun sum(x: Int, y: Int): Int { // 3
    return x + y
}

fun multiply(x: Int, y: Int) = x * y // 4

fun printALL(vararg message: String) {
    for (m in message) println(m)
}
fun printAllWithPrefix(vararg message: String, prefix: String) {
    for (m in message) println(prefix + m)
}

fun nullVar(nome: String?) {
    println(nome)
}

fun main() {
    var nullTeste = null

    nullVar(nullTeste)

    printAllWithPrefix(
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
