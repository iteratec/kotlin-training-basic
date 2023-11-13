package de.iteratec.kotlin.basic

import java.time.DayOfWeek
import java.time.LocalDate
import kotlin.random.Random

/**
 * Things to discuss:
 * - function types & typealias
 * - invoking lambdas
 * - method references
 * - Kotlin lambda notation
 * - higher order functions
 * - scope functions
 */
fun main() {
    // Function types are just like any other type in Kotlin
    val clickCallback: () -> Unit = { println("Clicked!") } // Parameterless lambda
    val plusOperation: (Int, Int) -> Int = { x, y -> x + y }
    val minusOperation: (Int, Int) -> Int = { x: Int, y: Int -> x - y } // With explicit param types

    // Lambdas referenced in variables can be called like normal functions
    clickCallback()
    println(plusOperation(2, 4))

    // You can use type aliases to produce more expressive type names
    val otherClickCallback: OnClick = { println("Clicked!") }

    // You can reference existing methods with Class::method notation
    val addMethodRef: (Int, Int) -> Int = Int::plus


    // If last parameter is a function type, it can be lifted out of round parenthesis
    withoutUmlauts(text = "Strauß", block = { text -> println(text.uppercase()) })
    withoutUmlauts("Strauß") { text -> println(text.uppercase()) }

    // However, semantically similar parameters should be written in the same way
    tryExecute(onSuccess = { println("Great success: $it") }, onFailure = { println("Great failure $it") })


    // Kotlin supports higher-order functions, i.e. functions that process or produce other functions
    executeWhen(condition = { LocalDate.now().dayOfWeek == DayOfWeek.TUESDAY }) {
        println("Performing my weekly TODOs")
    }

    val prefixer = withPrefix("* ")
    println(prefixer(" my string"))
    println(withPrefix("* ")(" my string"))
}

typealias OnClick = () -> Unit

fun withoutUmlauts(text: String, block: (String) -> Unit) {
    val textWithoutUmlauts = text
            .replace("ä", "ae")
            .replace("ö", "oe")
            .replace("ü", "ue")
            .replace("ß", "ss")

    return block(textWithoutUmlauts)
}

fun tryExecute(onSuccess: (String) -> Unit, onFailure: (Exception) -> Unit) {
    if (Random.nextBoolean()) {
        onSuccess("it worked!")
    } else {
        onFailure(IllegalStateException("it's over now"))
    }
}

fun executeWhen(condition: () -> Boolean, block: () -> Unit) {
    if (condition()) {
        block()
    }
}

fun withPrefix(prefix: String): (String) -> String {
    return { text -> prefix + text }
}