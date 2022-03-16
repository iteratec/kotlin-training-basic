package de.iteratec.kotlin.playground

import org.junit.Test

class DestructuringTasks {

    /**
     * ## Multiple return values from a function
     * The Pair<A,B> class is very useful in Kotlin. An instance of Pair<A,B> consists of an instance of A that can
     * be accessed via the first()-method and an instance of B that can be accessed via the second()-method.
     * Pair<A,B> supports destructuring declarations. Pair<A,B> is for instance used to represent key-value-pairs of
     * maps. Sometimes, we want a function to return multiple values without introducing a lot of boilerplate by
     * creating an extra class representing the return type.
     *
     * Create a new version of the function "createOrUpdate" named "createOrUpdateWithoutBoilerplateResultClass" such
     * that it returns a "Pair<A,B>" and the code below compiles.
     */
    @Test
    fun multipleReturnValuesFromAFunction() {
        val result: BoilerplateResultClass = createOrUpdate()
        println(result.hasBeenSuccessful)
        println(result.typeOfSave)

        // val (success, typeOfSave) = createOrUpdateWithoutBoilerplateResultClass()
        // println(success)
        // println(typeOfSave)
    }

    /**
     * ## Implementing destructing
     * Strings do not offer destructuring. Implement destructuring for strings in the sense that the first component
     * of the destructuring declaration is the first letter of the string. Destructing functions are declared as
     * operator overloading functions. Those have to start with the "operator" keyword and the name of the function
     * determines which operator will be defined.
     * For destructuring the function componentN defines the N-th component (where N is a positive number). Since we
     * do not own the String class, we have to define our Operator overload as an extension function. We have prepared
     * the right signature. It is up to you to provide the correct implementation.
     */
    @Test
    fun implementingDestructuring() {
        val (first) = "hallo"
        println("First letter of \"hallo\" is $first")
        val (shouldBeNull) = ""
        println("First letter of \"\" is $shouldBeNull")
    }

    operator fun String.component1(): Char? {
        TODO("Implement me please")
    }
}
