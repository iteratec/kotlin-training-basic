package de.iteratec.kotlin.basic

import org.junit.Test

class T15LambdasWithReceiversTasks {

    class LetterBuilder(/* Implement class members */)

    fun letter(/* Implement proper arguments */): String {
        // Create a letter builder, apply the customizations and finally return the letter from LetterBuilder.build()
        return "Implement me"
    }

    /**
     * ## Basic DSL
     * Lambdas with receivers allow you to easily write DSL-like constructs. In this task, we want to write a DSL, that
     * allows us to compose a simple letter. A letter consists for a header with a greeting, content and a footer containing
     * author's name.
     * Write a letter function, that accepts an author and lambda with receiver, that will allow you
     * to customize letter's greeting and content, so that it matches the assertion.
     */
    @Test
    fun lambdaWithReceiverBasics() {
//        val letterText: String = letter(author = "Bob") {
//            greeting("Hi, Alice")
//            content = "Please call me ASAP."
//        }
//
//        assertEquals("""
//            Hello, Hi, Alice
//            Please call me ASAP.
//            Regards, Bob
//        """.trimIndent(), letterText)
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
        println(
                whyDoesMyColleagueAlwaysHasToUseTheseIncrediblyLongVariableNamesWhichPreventMeCodingOnMySmartphoneAndAnnoyMeDeeply.name
        )
        println(
                whyDoesMyColleagueAlwaysHasToUseTheseIncrediblyLongVariableNamesWhichPreventMeCodingOnMySmartphoneAndAnnoyMeDeeply.isMarried
        )
        println(
                whyDoesMyColleagueAlwaysHasToUseTheseIncrediblyLongVariableNamesWhichPreventMeCodingOnMySmartphoneAndAnnoyMeDeeply.favouriteTechnology
        )
    }
}