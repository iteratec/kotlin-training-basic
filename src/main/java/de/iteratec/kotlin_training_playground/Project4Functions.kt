package de.iteratec.kotlin_training_playground

fun printSomething(message: String) {
    println(message)
}

fun add(a: Int, b: Int): Int {
    return a + b
}

fun main() {
//    val uuid = toUUID("ff820e1b-312f-4e48-94b0-967f3808dc8c")
//    println(uuid)

    val sumOf2And4 = add(2, 4)
    println("sum of 2 and 4 is $sumOf2And4")


//    printLazy({
//        "sum of 123 and 321 is ${sum(123, 321)}"
//    })
}

// show extension functions

// show default parameters

// show types & short-hand syntax for expressions

// show lambda: printLazy()
