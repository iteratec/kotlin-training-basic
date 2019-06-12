package de.iteratec.kotlin_training_playground

import java.util.*

fun printSomething(message: String) {
    println(message)
}

fun printLazy(lazyMessage: () -> String) {
    println(lazyMessage())
}

fun Int?.doubleIt() = if (this == null) null else this * 2

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun String.toUUID(): UUID = UUID.fromString(this)

fun main() {
    printSomething("something")
    val sumOf2And4 = sum(2, 4)
    printSomething("sum of 2 and 4 is $sumOf2And4")

    val uuid = "ff820e1b-312f-4e48-94b0-967f3808dc8c".toUUID()
    println(uuid)

    printLazy {
        "sum of 123 and 321 is ${sum(123, 321)}"
    }
}

// show default parameters

// show extension functions

// show types & short-hand syntax for expressions

// show lambda: printLazy()
