package de.iteratec.kotlin.basic

data class ExampleDataClass(
    val first: String,
    val second: Int
)

fun main() {
    val example = ExampleDataClass("first", 2)
    // Many existing classes in Kotlin offer positional destructuring. With this technique you can assign several variables at once.
    // Destructuring for lists extracts the first elements. You can skip the assignment of an attribute to a variable by using the placeholder "_"
    val myList = listOf(1, 2, 3, 4, 5)
    val (position1, _, position3) = myList

    // Data classes support destructuring. The order of the attributes in the constructor is important.
    val (first: String, second: Int) = example
}
