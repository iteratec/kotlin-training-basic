package de.iteratec.kotlin.bestpractises

import org.junit.Test
import java.io.IOException
import kotlin.random.Random

/**
 * TODO
 * + var macht smart-casts kaputt
+ überladene operatoren für listen listOf(1, 2) + 3
+ exahustive when
+ avoid else in when
+ runCatching


 * Declaring multiple classes in one file
 * use when
 * require block
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/require.html
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/check.html
 * Use Pair and Triple as return values sparingly, use custom classes
 * Avoid nesting lambdas
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/use.html
 * Elvis throws
service as? CustomerService ?: throw IllegalArgumentException("No CustomerService")

Nullable Boolean values in conditions
loops with ranges
 */
class T06Idioms {

    /**
     *  Solution [de.iteratec.kotlin.bestpractises.solutions.T06Idioms.fallbackChain]
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
     *  Solution [de.iteratec.kotlin.bestpractises.solutions.T06Idioms.shortCircuitElvis]
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
     *  Solution [de.iteratec.kotlin.bestpractises.solutions.T06Idioms.scopeFunctions]
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
     *  Solution [de.iteratec.kotlin.bestpractises.solutions.T06Idioms.exceptionHandlingWithRunCatching]
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
     *  Solution [de.iteratec.kotlin.bestpractises.solutions.T06Idioms.typeAlias]
     */
    @Test
    fun typeAlias() {
        class Person(val name: String)
        class PersonConsumerChain(private val processors: List<(Person) -> Unit>) {
            fun process(person: Person) = processors.forEach { processor -> processor(person) }
        }

        val consumerChain = PersonConsumerChain(listOf(
            { person-> println("Hello ${person.name}") },
            { person-> println("Bye ${person.name}") }
        ))

        consumerChain.process(Person(name = "Bob"))
    }

    /**
     *  Solution [de.iteratec.kotlin.bestpractises.solutions.T06Idioms.exhaustiveWhen]
     */
    sealed class LanguageToken
    object LeftParenthesis : LanguageToken()
    object RightParenthesis : LanguageToken()
    class TextValue(val value: String): LanguageToken()
    class Semicolon: LanguageToken()

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
                else -> ""
            }
        }

        println("Input $input transpiled to $transpiled")
    }

    /**
     *  Solution [de.iteratec.kotlin.bestpractises.solutions.T06Idioms.lightweightAop]
     */
    @Test
    fun lightweightAop() {
        class TransactionManager
        data class TransactionPropagation(val value: String)
        class TransactionTemplate(private val txManager: TransactionManager) {
            fun execute(transactionPropagation: TransactionPropagation, block: () -> Unit) {
                println("Starting transaction with propagation = $transactionPropagation")
                block()
                println("Transaction completed")
            }
        }

        fun saveItem(item: String) {
            val transactionManager = TransactionManager()
            val transactionTemplate = TransactionTemplate(transactionManager)
            transactionTemplate.execute(TransactionPropagation("new")) {
                println("Saving $item to database")
            }
        }

        saveItem("test")
    }
}