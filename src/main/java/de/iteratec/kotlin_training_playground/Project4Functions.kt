package de.iteratec.kotlin_training_playground

import java.util.*


fun String.toUUID(): UUID = UUID.fromString(this)

fun Int?.doubleIt() = if (this == null) null else this * 2

fun invokeAndPrint(operation: (a: Int, b: Int) -> Int, first: Int, second: Int) {
    println(operation(first, second))
}

fun add(a: Int, b: Int = 0): Int {
    //println("Adding $a and $b")
    return a + b
}

fun subtract(a: Int, b: Int): Int {
    return a - b
}

fun printLazy(lazyMessage: () -> String) {
    println(lazyMessage())
}

fun main() {
    // regular invocation of a method (with a default param)
    val sumOf2AndDefaultParam = add(2)
    println("sum of 2 and defaultParam is $sumOf2AndDefaultParam")
    // methods can also be directly invoked in a template String
    println("sum of 2 and 4 is ${add(2, 4)} in a template string")


    val uuid = "ff820e1b-312f-4e48-94b0-967f3808dc8c".toUUID()
    println(uuid)
    val doubled = 2.doubleIt()
    println("2 doubled is $doubled")


    // pass a method reference
    invokeAndPrint(::subtract, 100, 2)
    // pass a lambda
    invokeAndPrint({ a, b -> a * b }, 4, 4)
    // pass anonymous function
    invokeAndPrint(fun(a: Int, b: Int): Int {
        return a / b
    }, 10, 2)


    // pass an anonymous function that provides a string 'lazily'
    printLazy(fun(): String {
        return "sum of 123 and 321 is ${add(123, 321)}"
    })
    // or use a lambda
    // - as the lambda is the last param, it can be moved out of the 'printLazy(  )' parentheses
    // - as the lambda is actually the only param, we can even remove those parentheses
    printLazy {
        "sum of 123 and 321 is ${add(123, 321)}"
    }
    // try whether 'add' wil be called, if inside printLazy the lazyMessage()-call is *not* invoked
}

// show extension functions

// show default parameters

// show types & short-hand syntax for expressions

// show lambda: printLazy()
