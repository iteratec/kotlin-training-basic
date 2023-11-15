package de.iteratec.kotlin.basic

import java.util.Collections.singletonList

/**
Requirements:
- Functions
- MutabilityAndExpressions

Things to explain as instructor:
- String templates
- Multi-line strings
 */

fun main() {
    // You can evaluate expressions inside a String definition. toString() is called automatically.
    println("This is a template string: ${singletonList("item")}")

    val yourCleverAssistant = "IntelliJ"
    println("Sometimes you can omit the curly brackets. $yourCleverAssistant will notify you when this is the case.")

    // Multiline strings allow for nice formatting and conveniently escape some characters automatically.
    // You can activate syntax highlighting (Right-Click on string -> Show Context Actions -> Inject language or reference -> JSON)
    val uglyJson = "{\n\"property\":\"value\",\n\"array\":[\n\"element1\",\n\"element2\"\n]\n}"

    // language=json
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
}
