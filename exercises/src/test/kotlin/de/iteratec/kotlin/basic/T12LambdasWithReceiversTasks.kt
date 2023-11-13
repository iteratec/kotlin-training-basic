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
     * ## 'apply' scope function
     * The scope function apply() can be used on any object. It allows you to easily call methods of the receiver
     * object as you were inside a regular method of the receiver. apply() will always return the original object
     * it was called on.
     * Use apply() function on the string builder to simplify the appending.
     */
    @Test
    fun applyScopeFunctionUsage() {
        val builder = StringBuilder()
        builder.append("Hello,")
        builder.append(" this is a task")
        builder.append(" that uses Kotlin's apply scope function.")
        println(builder.toString())
    }

    /**
     * ## 'with' scope function
     * The scope function 'with' allows you to execute arbitrary code as if you were inside a regular method of the
     * passed receiver. 'with' function can return an arbitrary value.
     * Refactor the following code using the 'with' scope function, so it mentions the long variable name only once.
     */
    @Test
    fun withScopeFunctionUsage() {
        class IteratecMitarbeiter(val name: String, val isMarried: Boolean, val favouriteTechnology: String)

        val thisIsAVariableWithAVeryLongNameThatIDontWantToTypeTooOften = IteratecMitarbeiter(
                name = "Heiko",
                isMarried= true,
                favouriteTechnology = "MS Word"
        )

        // Block with repetitive use of our variable
        println(thisIsAVariableWithAVeryLongNameThatIDontWantToTypeTooOften.name)
        println(thisIsAVariableWithAVeryLongNameThatIDontWantToTypeTooOften.isMarried)
        println(thisIsAVariableWithAVeryLongNameThatIDontWantToTypeTooOften.favouriteTechnology)
    }
}