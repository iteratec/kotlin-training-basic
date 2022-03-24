package de.iteratec.kotlin.playground

import org.junit.Assert.assertEquals
import org.junit.Test

class T01FunctionsTasks {
    /**
     * ## Function syntax
     * Define a function addAll that takes 4 integers (type Int in Kotlin) as input and returns the sum.
     * Try the normal function definition syntax and also the one-liner syntax.
     */
    @Test
    fun functionSyntaxTask() {
        // assertEquals(6, addAll(0, 1, 2, 3))
    }

    /**
     * ## Calling functions with named arguments
     * "addAll" has many arguments. Theoretically one could mix up the order when calling the function. Replace the
     * invocation in the assertion with an invocation with named arguments.
     * You can also play around and mix positional and named arguments to see what happens.
     */
    @Test
    fun callingFunctionsWithNamedArgumentsTask() {
        // assertEquals(6, addAll(0, 1, 2, 3))
    }

    /**
     * ## Default values
     * It would also make sense to call "addAll" with 2 or 3 arguments. Add default values for c and d such that the
     * code below compiles and prints the desired results.
     */
    @Test
    fun defaultValues() {
        /*
        assertEquals(addAll(0, 1), 1)
        assertEquals(addAll(0, 1, 2), 3)
        */
    }
}
