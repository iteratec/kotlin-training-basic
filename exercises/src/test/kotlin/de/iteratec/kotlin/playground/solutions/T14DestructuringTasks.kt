package de.iteratec.kotlin.playground.solutions

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertTrue
import org.junit.Test

class BoilerplateResultClass(
    val hasBeenSuccessful: Boolean,
    val typeOfSave: TypeOfSave
)

enum class TypeOfSave {
    NEW, UPDATE
}

fun createOrUpdate(): BoilerplateResultClass {
    return BoilerplateResultClass(true, TypeOfSave.NEW)
}

fun createOrUpdateWithoutBoilerplateResultClass(): Pair<Boolean, TypeOfSave> {
    return Pair(true, TypeOfSave.NEW)
}

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
     * that it returns a "Pair<Boolean, TypeOfSave>" and the code below compiles.
     */
    @Test
    fun multipleReturnValuesFromAFunction() {
        val result: BoilerplateResultClass = createOrUpdate()
        println(result.hasBeenSuccessful)
        println(result.typeOfSave)

        val (success, typeOfSave) = createOrUpdateWithoutBoilerplateResultClass()
        assertTrue(success)
        assertThat(typeOfSave, equalTo(TypeOfSave.NEW))
    }

    /**
     * ## Implementing destructing
     * Strings do not offer destructuring. Implement destructuring for strings in the sense that the first component
     * of the destructuring declaration is the first letter of the string. Destructing functions are declared an operator overloading functions.
     * They have to start with the "operator" keyword and have to be named "componentN" where N is a positive number and denotes the N-th element extracted.
     * Since we do not own the String class, we have to define our Operator overload as an extension function. We have prepared
     * the right signature. It is up to you to provide the correct implementation.
     */
    @Test
    fun implementingDestructuring() {
        val (first) = "hallo"
        assertThat(first, equalTo('h'))
        val (shouldBeNull) = ""
        assertThat(shouldBeNull, equalTo(null))
    }

    operator fun String.component1(): Char? {
        return this.firstOrNull()
    }
}
