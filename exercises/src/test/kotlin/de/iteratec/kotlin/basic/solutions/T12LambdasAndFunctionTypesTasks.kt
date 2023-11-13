package de.iteratec.kotlin.basic.solutions

import org.junit.Assert.*
import org.junit.Test

class LambdasAndFunctionTypesTasks {

    /**
     * ## Lambda bracket convention
     * Why is there the convention in Kotlin to remove a lambda out of the argument list if it is the last argument?
     * Answer: You can for instance define functions in Kotlin that behave similar to the if-keyword in Java.
     *
     * Supply the right type for codeBlock and implement the function ifNot.
     */
    @Test
    fun lambdaBracketConvention() {
        fun ifNot(condition: Boolean, codeBlock: () -> Unit) {
            if (!condition) {
                codeBlock()
            }
        }

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
        val greet = { greetingWord: String -> { name: String -> "$greetingWord, $name" } }
        assertEquals("Hello, Alice", greet("Hello")("Alice"))
    }
}
