package de.iteratec.kotlin.basic

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
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
     * ## let function and null-safety
     * Replace the implementation of wrapIntoList with a suitable one-liner using "let".
     */
    @Test
    fun letAndNullSafety() {
        fun wrapIntoList(input: Int?): List<Int> = emptyList()

        assertTrue(wrapIntoList(null).isEmpty())
        assertThat(wrapIntoList(2), equalTo(listOf(2)))
    }

    /**
     * Task higherOrderFunction
     * A higher-order-function is a function whose return type is again a function. Complete the generic (same syntax as in Java) function "curry" that basically does the following:
     * If doSomething is a lambda expecting 2 arguments, then
     * doSomething(a, b) = (curry(doSomething, a)) (b)
     * In case you have problems with the generics, write two concrete versions of "curry" for "multiply" resp. "concatenate" first.
     */
    @Test
    fun higherOrderFunctions() {
        println("#### Task higherOrderFunctions")
        val multiply = { factor1: Int, factor2: Int -> factor1 * factor2 }
        val concatenate = { string1: String, string2: String -> string1 + string2 }

        /*fun <A, B, C> curry( function: ???, firstInput: ???): ??? {
            return ???
        }

        val multiplyWith3 = curry(multiply, 3)
        assertThat(multiplyWith3(5), equalTo(15))

        val insultPrepender = curry(concatenate, "Hey, du Opfer! ")
        assertThat(insultPrepender("Wären Sie bitte so freundlich, mir den Tee zu reichen?"), equalTo("Hey, du Opfer! Wären Sie bitte so freundlich, mir den Tee zu reichen?"))
        */
    }
}
