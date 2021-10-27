package de.iteratec.kotlin_training_playground

import java.util.Collections.singletonList

fun main() {
    // You can evaluate expressions inside a String definition. toString() is called automatically.
    println("This is a template string: ${singletonList("item")}")

    val yourCleverAssistant = "IntelliJ"
    println("Sometimes you can omit the curly brackets. $yourCleverAssistant will notify you when this is the case.")

    // Multiline strings allow for nice formatting and conveniently escape some characters automatically.
    val uglyJson = "{\n\"property\":\"value\",\n\"array\":[\n\"element1\",\n\"element2\"\n]\n}"
    val multiLineString = """
            {
                "property": "value",
                "array": [
                    "element1",
                    "element2"
                ]
            }
        """.trimIndent().replace(" ", "")
    println(multiLineString == uglyJson)

    // Try it yourself

    stringInterpolation()
    multiLineString()
}

val prefix = "Prefix"
val suffix = "suffix"

/**
 * Task stringInterpolation
 * Replace the concatenation with a single Template String.
 */
fun stringInterpolation() {
    println("###Task stringInterpolation: Should print PrefixInfixSUFFIX")
    println(prefix + "Infix" + suffix.uppercase())
}

/**
 * Task multilineString
 * Write the string below in more human-readable form using a multi-line string
 */
fun multiLineString() {
    println("###Task multiLineString")
    val header = "Famous last words:\n"
    val blankLine = "\n"
    val firstLine = "Anna: \"It worked on my machine!\"\n"
    val secondLine = "Sven: \"All tests are green. What could possibly go wrong?\""

    val originalString = header + blankLine + firstLine + secondLine
    println(originalString)

    val multilineString = """
        Place your content here
    """.trimIndent()

    println(originalString == multilineString)
}
