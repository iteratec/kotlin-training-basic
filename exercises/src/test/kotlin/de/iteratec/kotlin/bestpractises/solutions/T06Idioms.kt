package de.iteratec.kotlin.bestpractises.solutions

import org.junit.Test
import java.io.IOException
import kotlin.random.Random


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

    /**
     *  Solution [de.iteratec.kotlin.bestpractises.solutions.T06Idioms.typeAlias]
     */
    @Test
    fun typeAlias() {

    }

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
                is Semicolon -> "!"
            }
        }

        println("Input $input transpiled to $transpiled")
    }

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

        fun inNewTransaction(transactionManager: TransactionManager, block: () -> Unit) {
            val transactionTemplate = TransactionTemplate(transactionManager)
            transactionTemplate.execute(TransactionPropagation("new")) {
                block()
            }
        }

        val transactionManager = TransactionManager()
        fun saveItem(item: String) = inNewTransaction(transactionManager) {
            println("Saving $item to database")
        }

        saveItem("test")
    }
}