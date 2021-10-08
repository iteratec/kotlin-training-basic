package de.iteratec.kotlin_training_playground

private val prefix = "Prefix"
private fun getSuffix() = "Suffix"

fun main() {
    stringInterpolation()
    multiLineString()
}

/**
 * Task stringInterpolation
 * Replace String interpolation rather than concatenation.
 */
fun stringInterpolation() {
    println("Task stringInterpolation")
    println(prefix + "Infix" + getSuffix())
}

/**
 * Task multilineString
 * Write the JSON in human-readable form into multiLineString
 */
fun multiLineString() {
    println("Task multiLineString")
    val multiLineString = """
            // Place
            // text
            // here
        """.trimIndent().replace(" ", "")
    val uglyJson = "{\n\"property\":\"value\",\n\"array\":[\n\"element1\",\n\"element2\"\n]\n}"
    println("uglyJson equals multiLineString? ${multiLineString == uglyJson}")
}
