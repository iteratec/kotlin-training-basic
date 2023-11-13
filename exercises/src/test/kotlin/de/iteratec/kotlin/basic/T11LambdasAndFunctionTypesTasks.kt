package de.iteratec.kotlin.basic

import org.junit.Assert.*
import org.junit.Test

class LambdasAndFunctionTypesTasks {

    /**
     * ## Lambda declarations & calls
     * Lambda expressions can be assigned to a variable and then called like a regular function.
     * Uncommend the code and implement a multiply lambda, that takes two integers and returns their product
     */
    @Test
    fun lambdaBasics() {
//        val multiply = TODO()
//        assertEquals(6, multiply(2, 3))
//        assertEquals(10, multiply(2, 5))
    }

    /**
     * ## Lambda bracket convention
     * You can define functions that behave similar to the if-keyword in Java by using the Kotlin's bracket convention
     * for lambdas.
     *
     * Supply the right type for codeBlock and implement the function ifNot. It should work as a negated if-statement
     * that executed, when the supplied condition is 'false'.
     */
    @Test
    fun lambdaBracketConvention() {
        fun ifNot(condition: Boolean, codeBlock: Any) {}

        ifNot(true) {
            fail("This should not be executed")
        }

        var codeBlockHasRun = false
        ifNot(false) {
            codeBlockHasRun = true
        }

        assertTrue(codeBlockHasRun)
    }

    /**
     * ## Higher-order functions
     * A higher-order-function is a function whose return type is again a function.
     * Uncomment the code and implement the `greet` lambda, that takes a greeting word and returns a function, that
     * takes a name of the person to greet and produces a string in form "<Greeting>, <Name>"
     */
    @Test
    fun higherOrderFunctions() {
//        val greet = TODO("Implement me!")
//        assertEquals("Hello, Alice", greet("Hello")("Alice"))
    }
}