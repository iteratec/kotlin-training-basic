package de.iteratec.kotlin.bestpractises

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

    if (initializer.value != null) {
        println("${initializer.value}")
    }

    if(initializer.values != null) {
        initializer.values.forEachIndexed { index, value ->
            println("$index: $value (${value?.length})")
        }
    }

    val value = getValue()!!

}


fun getValue(): String? {
    return null
}

class Initializer {
    var value: String? = null

    val values: List<String?>? = listOf("value1", "value2")

    fun initValue(value: String) {
        this.value = value
    }
}