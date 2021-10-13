package de.iteratec.kotlin_training_playground

import java.util.Collections.singletonList

private val prefix = "Prefix"
private fun getSuffix() = "Suffix"

// Show:
//
// Mention brackets and toString for template strings.
// Mention escaping of multi-line strings
// Syntax highlighting for multi-line strings
// Show indentation of multi-line strings (trimIndent.replaceAll())


fun main() {
    println("This is a template string: ${singletonList("item")}") // toString is called automatically

    val yourCleverAssistant = "IntelliJ"
    println("Sometimes you can omit the curly brackets. $yourCleverAssistant will notify you when this is the case.")

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

/**
 * Task stringInterpolation
 * Replace String interpolation rather than concatenation.
 */
fun stringInterpolation() {
    println("###Task stringInterpolation")
    println(prefix + "Infix" + getSuffix())
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
    val secondLine = "Sven: \"All tests are green. There cannot be an error.\""

    val originalString = header + blankLine + firstLine + secondLine
    println(originalString)

    val multilineString = """
        Place your content here
    """.trimIndent()

    println(originalString == multilineString)
}
