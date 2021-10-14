package de.iteratec.kotlin_training_playground

fun main() {
    lambdaSyntax()
    lambdaBracketConvention()
    letAndNullSafety()
    higherOrderFunctions()
}

/**
 * Task lambdaSyntax
 * We want to capitalize myString by using the "let"-function and a lambda that capitalizes a String
 * Do this once by assigning your lambda to capitalizer and using its reference in let.
 * Do it again by defining the lambda inside the map declaration.
 */
private fun lambdaSyntax() {
    println("#### Task lambdaSyntax")

    val capitalizer = {}

    val myString = "klein"

    val myStringCapitalizedByCapitalizer = ""
    val myStringCapitalizedByAnonymousLambda = ""
    println(myStringCapitalizedByCapitalizer)
    println(myStringCapitalizedByAnonymousLambda)
}


/**
 * Why is there the convention in Kotlin to remove a lambda out of the argument list?
 * You can for instance define functions in Kotlin that behave similar to the if-keyword in Java. See the following example.
 * Supply the right type for codeBlock and implement the function ifNot.
 */
fun lambdaBracketConvention() {
    println("#### Task lambdaBracketConvention")
/*        fun ifNot(condition: Boolean, codeBlock: ???) {
            // TODO: Implement
        }

        ifNot(true) {
            println("This should not appear on your screen")
        }

        ifNot(false) {
            println("This should appear on your screen")
        }*/
}

/**
 * Task letAndNullSafety
 * Supply the right lambda to the implementation of wrapIntoTheList in order to make both assertions green.
 */
fun letAndNullSafety() {
    println("#### Task letAndNullSafety")
    fun wrapIntoList(input: Int?) = input?.let {} ?: ArrayList<Int>()

    println("wrapIntoList(null) should give an empty list: ${wrapIntoList(null)}")
    println("wrapIntoList(2) should give a list with 2 as the sole element: ${wrapIntoList(2)}")
}

/**
 * Task higherOrderFunction
 * A higher-order-function is a function whose return type is again a function. Write a generic (same syntax as in Java) function "curry" that basically does the following:
 * If doSomething is a lambda expecting 2 arguments, then
 * doSomething(a, b) = (curry(doSomething, a)) (b)
 */
fun higherOrderFunctions() {
    println("#### Task higherOrderFunctions")
    val multiply = { factor1: Int, factor2: Int -> factor1 * factor2 }
    val concatenate = { string1: String, string2: String -> string1 + string2}

/*        val insultPrepender = curry(concatenate, "Hey, du Opfer! ")
        val multiplyWith3 = curry(multiply, 3)

        println(insultPrepender("Wären Sie bitte so freundlich, mir den Tee zu reichen?") == "Hey, du Opfer! Wären Sie bitte so freundlich, mir den Tee zu reichen?")
        println((multiplyWith3(5) == 15)
        */
}