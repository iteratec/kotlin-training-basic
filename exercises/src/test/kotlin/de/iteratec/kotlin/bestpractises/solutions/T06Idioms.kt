package de.iteratec.kotlin.bestpractises.solutions

import org.junit.Test
import java.io.BufferedOutputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.lang.Thread.sleep
import java.time.Duration
import kotlin.random.Random

class Flower(val name: String, val color: String)
typealias FlowersByColor = Map<String, List<Flower>>
typealias FlowersByColorConsumer = (Map<String, List<Flower>>) -> Unit

class T06Idioms {

    @Test
    fun fallbackChain() {
        fun getUserFromSession(): String? = if (Random.nextBoolean()) "alice" else null
        fun getUserFromCache(): String? = if (Random.nextBoolean()) "bob" else null
        fun getUserFromDb(): String? = if (Random.nextBoolean()) "chris" else null

        val user = getUserFromSession()
            ?: getUserFromCache()
            ?: getUserFromDb()
            ?: "defaultUser"

        println("Got user $user")
    }

    @Test
    fun shortCircuitElvis() {
        fun getUserFromDb(): String? = if (Random.nextBoolean()) "chris" else null

        val user: String = getUserFromDb() ?: throw IllegalStateException("User not found")
        println("User = $user")
    }

    @Test
    fun nullableBoolConditions() {
        val maybeTrue: Boolean? = if (Random.nextBoolean()) true else null
        if (maybeTrue == true) {
            println("It was true!")
        }
    }

    @Test
    fun parameterValidation() {
        fun validateName(personName: String?) {
            requireNotNull(personName)
            require(personName.length <= 20) { "Person name is too long" }
            // There's also check() for state assertions
        }
    }

    @Test
    fun scopeFunctions() {
        class Person(val name: String, val age: Int)
        class DriverLicense(val owner: String)

        fun saveDriverLicenseInDb(license: DriverLicense) = Unit

        val bob = Person(name = "Bob", age = 24)
        val bobsDriverLicense = bob
            .takeIf { it.age >= 18 }
            ?.let { DriverLicense(owner = it.name) }
            ?.also { saveDriverLicenseInDb(it) }

        println("Bob's driver license = $bobsDriverLicense")
    }

    @Test
    fun exceptionHandlingWithRunCatching() {
        data class Person(val name: String, var isSaved: Boolean = false)

        fun saveInDb(person: Person): Person =
            if (Random.nextBoolean()) person.copy(isSaved = true) else throw IOException("Connection error")

        val person = Person(name = "bob")
        runCatching { saveInDb(person) }
            .onSuccess { println("Value '$it' saved successfully") }
            .onFailure { println("Error while saving '$it' to database, will retry once") }
            .recoverCatching { saveInDb(person) }
            .onFailure { println("Saving failed again") }
    }

    @Test
    fun useFunction() {
        val buffer = BufferedOutputStream(ByteArrayOutputStream())
        buffer.use { buffer.write(1) }
    }

    @Test
    fun typeAlias() {
        // Type aliases must be declared at the top level
        val flowersByColor: FlowersByColor = listOf(
            Flower(name = "tulip", color = "red"),
            Flower(name = "rose", color = "red"),
            Flower(name = "sunflower", color = "yellow")
        ).groupBy { it.color }

        val flowersByColorPrinter: FlowersByColorConsumer = { println(it) }
        flowersByColorPrinter(flowersByColor)
    }

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
        val transpiled = tokens.joinToString(separator = "") { token ->
            when (token) {
                is LeftParenthesis -> "{"
                is TextValue -> "~${token.value}~"
                is RightParenthesis -> "}"
                is Semicolon -> "!"
            }
        }

        println("Input $input transpiled to $transpiled")
    }

    @Test
    fun lightweightAop() {
        fun timed(block: () -> Unit) {
            val start = System.currentTimeMillis()
            block()
            val duration = System.currentTimeMillis() - start
            println("Method execution took $duration ms")
        }

        fun sampleMethod() = timed {
            sleep(400)
        }

        sampleMethod()
    }

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
