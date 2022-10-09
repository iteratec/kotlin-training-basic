package de.iteratec.kotlin.bestpractises

import org.junit.Test
import java.io.BufferedOutputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.lang.Thread.sleep
import kotlin.random.Random

class T06Idioms {

    /**
     * Use Elvis operator to avoid long null-check statements.
     * Solution [de.iteratec.kotlin.bestpractises.solutions.T06Idioms.fallbackChain]
     */
    @Test
    fun fallbackChain() {
        fun getUserFromSession(): String? = if (Random.nextBoolean()) "alice" else null
        fun getUserFromCache(): String? = if (Random.nextBoolean()) "bob" else null
        fun getUserFromDb(): String? = if (Random.nextBoolean()) "chris" else null

        var user = getUserFromSession()
        if (user == null) {
            user = getUserFromCache()
        }
        if (user == null) {
            user = getUserFromDb()
        }
        if (user == null) {
            user = "defaultUser"
        }

        println("Got user $user")
    }

    /**
     * Use Elvis operator to break out from the function on unexpected null values.
     * Solution [de.iteratec.kotlin.bestpractises.solutions.T06Idioms.shortCircuitElvis]
     */
    @Test
    fun shortCircuitElvis() {
        fun getUserFromDb(): String? = if (Random.nextBoolean()) "chris" else null

        val user: String? = getUserFromDb()
        if (user == null) {
            throw IllegalStateException("User not found")
        }

        println("User = $user")
    }

    /**
     * Use `== true` and `== false` to test nullable booleans.
     * Solution [de.iteratec.kotlin.bestpractises.solutions.T06Idioms.nullableBoolConditions]
     */
    @Test
    fun nullableBoolConditions() {
        val maybeTrue: Boolean? = if (Random.nextBoolean()) true else null
        if (maybeTrue != null && maybeTrue) {
            println("It was true!")
        }
    }

    /**
     * Use `require` and `requireNotNull` functions for parameter validation.
     * Solution [de.iteratec.kotlin.bestpractises.solutions.T06Idioms.parameterValidation]
     */
    @Test
    fun parameterValidation() {
        fun validateName(personName: String?) {
            if (personName == null) {
                throw IllegalArgumentException("Person name cannot be null")
            }

            if (personName.length > 20) {
                throw IllegalArgumentException("Person name is too long")
            }
        }
    }

    /**
     * Use scope functions `takeIf`, `let`, `also`, `apply` to handle transformations of a single values
     * in a functional way (similarly to collections).
     * Solution [de.iteratec.kotlin.bestpractises.solutions.T06Idioms.scopeFunctions]
     */
    @Test
    fun scopeFunctions() {
        data class Person(val name: String, val age: Int)
        data class DriverLicense(val owner: String)

        fun saveDriverLicenseInDb(license: DriverLicense) = Unit

        val bob = Person(name = "Bob", age = 24)
        val bobsDriverLicense = if (bob.age >= 18) {
            val license = DriverLicense(owner = bob.name)
            saveDriverLicenseInDb(license)
            license
        } else {
            null
        }

        println("Bob's driver license = $bobsDriverLicense")
    }

    /**
     * Use `runCatching` to handle exceptions in a more concise, functional way.
     * Solution [de.iteratec.kotlin.bestpractises.solutions.T06Idioms.exceptionHandlingWithRunCatching]
     */
    @Test
    fun exceptionHandlingWithRunCatching() {
        data class Person(val name: String, var isSaved: Boolean = false)

        fun saveInDb(person: Person): Person =
            if (Random.nextBoolean()) person.copy(isSaved = true) else throw IOException("Connection error")

        val person = Person(name = "bob")

        try {
            saveInDb(person)
            println("Person saved successfully")
        } catch (ex: IOException) {
            println("Error while saving person to database, will retry once")
            try {
                saveInDb(person)
            } catch (ex: IOException) {
                println("Saving failed again")
            }
            println("Person saved successfully")
        }
    }

    /**
     * Use `use` extension function to automatically close resources.
     * There's a similar function `withLock` for lockable objects.
     * Solution [de.iteratec.kotlin.bestpractises.solutions.T06Idioms.useFunction]
     */
    @Test
    fun useFunction() {
        val buffer = BufferedOutputStream(ByteArrayOutputStream())
        try {
            buffer.write(1)
        } catch (ex: IOException) {
            println("Error while writing to buffer")
        } finally {
            try {
                buffer.close()
            } catch (ex: IOException) {
                println("Could not close buffer. Try to restart your PC.")
            }
        }
    }

    /**
     * Use `typealias` to shorten long names or create more meaningful names.
     *  Solution [de.iteratec.kotlin.bestpractises.solutions.T06Idioms.typeAlias]
     */
    @Test
    fun typeAlias() {
        class Flower(val name: String, val color: String)

        val flowersByColor: Map<String, List<Flower>> = listOf(
            Flower(name = "tulip", color = "red"),
            Flower(name = "rose", color = "red"),
            Flower(name = "sunflower", color = "yellow")
        ).groupBy { it.color }

        val flowersByColorPrinter: (Map<String, List<Flower>>) -> Unit = {
            println(it)
        }

        flowersByColorPrinter(flowersByColor)
    }

    /**
     * Do not use else in a when-block, when no reasonable default value can be returned.
     * Let the compiler find the when-statements, that have to be adjusted when new enum/sealed subclass is added.
     * Solution [de.iteratec.kotlin.bestpractises.solutions.T06Idioms.exhaustiveWhen]
     */
    sealed class LanguageToken
    object LeftParenthesis : LanguageToken()
    object RightParenthesis : LanguageToken()
    class TextValue(val value: String) : LanguageToken()
    class Semicolon : LanguageToken()

    @Test
    fun exhaustiveWhen() {
        val input = "(hello)"
        // Parsed list of tokens corresponding to (hello)
        val tokens = listOf(LeftParenthesis, TextValue("hello"), RightParenthesis)

        // Translates (hello) into {~hello~}
        val transpiled = tokens.joinToString(separator = "") { token ->
            when (token) {
                is LeftParenthesis -> "{"
                is TextValue -> "~${token.value}~"
                is RightParenthesis -> "}"
                else -> throw IllegalArgumentException("Unknown token")
            }
        }

        println("Input $input transpiled to $transpiled")
    }

    /**
     * Use lambdas to create a lightweight alternative for AOP.
     * Solution [de.iteratec.kotlin.bestpractises.solutions.T06Idioms.lightweightAop]
     */
    @Test
    //@Timed - would measure and print method's execution time
    fun lightweightAop() {
        sleep(400)
    }

    /**
     * Use range literals, `until` or `repeat` to execute certain operation N times.
     * Collection operations should be though preferred if applicable.
     * Solution (none).
     */
    @Test
    fun rangesAndRepetitions() {
        val closedRange = 0..5
        for (i in closedRange) {
           print("$i ")
        }
        println()

        val openRange = 0 until 5
        for (i in openRange) {
            print("$i ")
        }
        println()

        repeat(5) { i -> print("$i ") }
        println()
    }
}
