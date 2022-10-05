package de.iteratec.kotlin.bestpractises.solutions

/**
 * # Nullsafety
 *
 * - no !! (Bang-Bang)
 * - no nullable for collections and enums
 * - use only nullable if really necessary, try lateinit if possible
 */

fun main() {
    val initializer = Initializer()

    initializer.initValue("initialized value")

    println(initializer.value)

    initializer.values.forEachIndexed { index, value ->
        println("$index: $value (${value.length})")
    }

    val value = getValue() ?: throw IllegalArgumentException("value is null")

}


fun getValue(): String? {
    return null
}

class Initializer {
    lateinit var value: String

    val values: List<String> = listOf("value1", "value2")

    fun initValue(value: String) {
        this.value = value
    }
}