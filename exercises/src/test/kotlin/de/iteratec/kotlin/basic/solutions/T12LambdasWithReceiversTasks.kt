package de.iteratec.kotlin.basic.solutions

import org.junit.Assert.assertEquals
import org.junit.Test

class T15LambdasWithReceiversTasks {

    class LetterBuilder(
            val author: String,
            var content: String = "",
            private var greeting: String = "Hello,",
    ) {
        fun greeting(name: String) {
            greeting = "Hello, $name"
        }

        fun build(): String {
            return """
                $greeting
                $content
                Regards, $author
            """.trimIndent()
        }
    }

    fun letter(author: String, block: LetterBuilder.() -> Unit): String {
        val letterBuilder = LetterBuilder(author)
        letterBuilder.block()
        return letterBuilder.build()
    }

    /**
     * ## Basic DSL
     * Lambdas with receivers allow you to easily write DSL-like constructs. In this task, we want to write a DSL, that
     * allows us to compose a simple letter. A letter consists for a header with a greeting, content and a footer containing
     * author's name.
     * Create a LetterBuilder class, that will hold all required letter data. Then, create a letter function, that
     * accepts an author and lambda with receiver. The function should apply the author and customizations provided
     * in the lambda to a LetterBuilder instance. Finally, you can use a build() method from LetterBuilder to assemble
     * the letter content and return it from the letter() function.
     */
    @Test
    fun lambdaWithReceiverBasics() {
        val letterText: String = letter(author = "Bob") {
            greeting("Hi, Alice")
            content = "Please call me ASAP."
        }

        assertEquals("""
            Hello, Hi, Alice
            Please call me ASAP.
            Regards, Bob
        """.trimIndent(), letterText)
    }

    /**
     * ## avoidRepetitionWithLambdasWithReceiversTask
     * The "with"-function is the simplest Kotlin-built-in example of a function expecting a lambda as receiver as a last argument.
     * When you have a lambda with receiver and a matching receiver, you can supply both as arguments to "with".
     * "with" will simply call the lambda on the receiver and return the result.
     *
     * fun <T, R> with(receiver: T, block: T.() -> R): R {
     *   return receiver.block()
     * }
     *
     * In the following we have to repeat the same variable all the time. Improve the situation by using the "with"-function
     */
    @Test
    fun avoidRepetitionWithLambdasWithReceiversTask() {
        class IteratecMitarbeiter(var name: String, var isMarried: Boolean, var favouriteTechnology: String)

        val whyDoesMyColleagueAlwaysHasToUseTheseIncrediblyLongVariableNamesWhichPreventMeCodingOnMySmartphoneAndAnnoyMeDeeply =
                IteratecMitarbeiter("Heiko", true, "MS Word")

        // Block with repetetive use of our variable
        with(whyDoesMyColleagueAlwaysHasToUseTheseIncrediblyLongVariableNamesWhichPreventMeCodingOnMySmartphoneAndAnnoyMeDeeply) {
            println(name)
            println(isMarried)
            println(favouriteTechnology)
        }
    }
}
