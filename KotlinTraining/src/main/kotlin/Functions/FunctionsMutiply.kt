package Functions // ktlint-disable package-name
// ktlint-disable package-name

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
