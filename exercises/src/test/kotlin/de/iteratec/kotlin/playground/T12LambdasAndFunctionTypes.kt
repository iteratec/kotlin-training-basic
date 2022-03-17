package de.iteratec.kotlin.playground

/**
 # Lambdas & function types
 Requirements:
 - Functions
 - Mutability and expressions
 - Collections and Lambdas

 Things to discuss:
 - Function types
 - Lambda convention
 - Scope functions
 */
fun main() {
    // You can save lambdas into variables and use them in any place where you can use variables.
    // Note that the brackets belong to the declaration of the lambda. The last line evaluated in a lambda gets returned automatically.
    val surroundMyStringWithSymbol: (String, String) -> String = {
            input, symbol -> "${symbol}${input}${symbol}"
    }

    println(surroundMyStringWithSymbol("word", "*"))
}
