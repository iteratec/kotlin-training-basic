package de.iteratec.kotlin.playground.solutions

import org.junit.Test

fun addAll(first: Int, second: Int, third: Int = 0, fourth: Int = 0): Int {
    return first + second + third + fourth
}

fun addAllInOneLinerSyntax(first: Int, second: Int, third: Int = 0, fourth: Int = 0) = first + second + third + fourth

class FunctionsExercises {

    /**
     * ## Function syntax
     * Define a function addAll that takes 4 integers (type Int in Kotlin) as input and returns the sum.
     * Try the normal function definition syntax and also the one-liner syntax.
     *
     * The function should print 6.
     */
    @Test
    fun functionSyntaxTask() {
        println(addAll(0, 1, 2, 3));
    }

    /**
     * ## Calling functions with named arguments
     * "addAll" has many arguments. Theoretically one could mix up the order when calling the function. Replace the
     * invocation above with an invocation with named arguments.
     * You can also play around and mix positional and named arguments to see what happens.
     *
     * The function should print 6.
     */
    @Test
    fun callingFunctionsWithNamedArgumentsTask() {
        println(addAll(first = 0, second = 1, third = 2, fourth = 3))
    }

    /**
     * ## Default values
     * It would also make sense to call "addAll" with 2 or 3 arguments. Add default values for c and d such that the
     * code below compiles and prints the desired results.
     *
     * The function should print 1 and 3.
     */
    @Test
    fun defaultValues() {
        println(addAll(0, 1))
        println(addAll(0, 1, 2))
    }
}
