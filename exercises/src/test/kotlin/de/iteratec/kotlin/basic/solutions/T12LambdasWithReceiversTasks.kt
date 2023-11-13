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
     * ## 'apply' scope function
     * The scope function apply() can be used on any object. It allows you to easily call methods of the receiver
     * object as you were inside a regular method of the receiver. apply() will always return the original object
     * it was called on.
     * Use apply() function on the string builder to simplify the appending.
     */
    @Test
    fun applyScopeFunctionUsage() {
        val builder = StringBuilder().apply {
            append("Hello,")
            append(" this is a task")
            append(" that uses Kotlin's apply scope function.")
        }

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
                isMarried = true,
                favouriteTechnology = "MS Word"
        )

        with(thisIsAVariableWithAVeryLongNameThatIDontWantToTypeTooOften) {
            println(name)
            println(isMarried)
            println(favouriteTechnology)
        }
    }
}
