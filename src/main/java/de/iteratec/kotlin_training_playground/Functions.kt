package de.iteratec.kotlin_training_playground

// default parameters
// extension functions
// types & short-hand syntax for expressions
// lambdas

fun printSomething(message: String) {
    println(message)
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun main() {
    printSomething("something")
    val sumOf2And4 = sum(2, 4)
    printSomething("sum of 2 and 4 is $sumOf2And4")

//    val uuid = toUUID("ff820e1b-312f-4e48-94b0-967f3808dc8c")
//    println(uuid)

//    printLazy({
//        "sum of 123 and 321 is ${sum(123, 321)}"
//    })
}

