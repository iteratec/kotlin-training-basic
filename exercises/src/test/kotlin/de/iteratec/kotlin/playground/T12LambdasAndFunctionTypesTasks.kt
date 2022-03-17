package de.iteratec.kotlin.playground

import org.junit.Test

class LambdasAndFunctionTypesTasks {

    /**
     * ## Lambda bracket convention
     * Why is there the convention in Kotlin to remove a lambda out of the argument list if it is the last argument?
     * You can for instance define functions in Kotlin that behave similar to the if-keyword in Java. See the following example.
     *
     * Supply the right type for codeBlock and implement the function ifNot.
     */
    @Test
    fun lambdaBracketConvention() {
        // Replace the `Any` type of `codeBlock` with a proper function type
        fun ifNot(condition: Boolean, codeBlock: Any) {
            TODO("Implement me")
        }

        ifNot(true) {
            println("This should not appear on your screen")
        }

        ifNot(false) {
            println("This should appear on your screen")
        }
    }

    /**
     * ## let function and null-safety
     * Supply the right lambda to the implementation of wrapIntoTheList in order to make both assertions green.
     */
    @Test
    fun letAndNullSafety() {
        val surroundMyStringWithSymbol: (String, String) -> String = {
                input, symbol -> "${symbol}${input}${symbol}"
        }

        // How do we call surroundMyStringWithSymbol upper function with a nullable string as input? Of course, we could surround it by a null-check using "if",
        // however this does not scale well with chained invocations of functions with nullable input.
        // Imagine how this would like in the following example, if "initial" were nullable.

        val initial: String = "initial"
        surroundMyStringWithSymbol(surroundMyStringWithSymbol(initial, "-"), "|")

        // Note that we would not have a problem here if our method would belong to the String class as an instance method
        // because then we could use the safe-call operator ?.
        // initial
        // ?.surroundThisWithSymbol("-")
        // ?.surroundThisWithSymbol("|")

        // Kotlin allows us to use to solve our initial problem with the "let"-function. Imagine "let" to be a generic instance method of
        // any class with the following implementation
        /*
        class MyClass {
            ...
            <T> fun let(code: (MyClass) -> T) {
                code(this)
            }
        } */
        // In other words, "receiver.let(lambda)" is the same as lambda(receiver).
        // Using this, we can write using the safe-call operator ?. on let
        val couldBeNull: String? = "initial"
        val resultForNonNullInput =
            couldBeNull?.let { surroundMyStringWithSymbol(surroundMyStringWithSymbol(it, "-"), "|") }
        println(resultForNonNullInput)

        val isNull: String? = null
        val resultForNullInput = isNull?.let { surroundMyStringWithSymbol(surroundMyStringWithSymbol(it, "-"), "|") }
        println(resultForNullInput)

        // Use the safe-call operator ?., let and the Elvis operator ?:
        fun wrapIntoList(input: Int?): List<Int> = emptyList() // Replace implementation with suitable one-liner

        println("wrapIntoList(null) should give an empty list: ${wrapIntoList(null)}")
        println("wrapIntoList(2) should give a list with 2 as the sole element: ${wrapIntoList(2)}")
    }

    /**
     * Task higherOrderFunction
     * A higher-order-function is a function whose return type is again a function. Write a generic (same syntax as in Java; see template at the end of the file) function "curry" that basically does the following:
     * If doSomething is a lambda expecting 2 arguments, then
     * doSomething(a, b) = (curry(doSomething, a)) (b)
     * In case you have problems with the generics, write two concrete versions for "multiply" resp. "concatenate" first.
     */
    @Test
    fun higherOrderFunctions() {
        println("#### Task higherOrderFunctions")
        val multiply = { factor1: Int, factor2: Int -> factor1 * factor2 }
        val concatenate = { string1: String, string2: String -> string1 + string2 }

/*        val insultPrepender = curry(concatenate, "Hey, du Opfer! ")
        val multiplyWith3 = curry(multiply, 3)

        println(insultPrepender("Wären Sie bitte so freundlich, mir den Tee zu reichen?") == "Hey, du Opfer! Wären Sie bitte so freundlich, mir den Tee zu reichen?")
        println((multiplyWith3(5) == 15))
        */
    }

/*fun <A, B, C> curry( function: ???, firstInput: ???): ??? {
    return ??? }
}*/

}
