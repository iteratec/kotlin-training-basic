package de.iteratec.kotlin.basic

fun main() {
    // Kotlin allows not only to define extension functions but also extension properties. Another exotic feature is to overload commonly used operators like "!" or "+".
    // These features are mainly used to write Domain-Specific languages in Kotlin, but can be useful from time to time.

    val list1 = listOf("element1")
    val list2 = listOf("element2")
    val joinedList = list1 + list2
    println(joinedList)

    // The + operator is overloaded for the Collection interface. In order to overload a particular operator, you need to
    // define a function using the "operator" keyword and certain function name representing the operator.
    // For lists the signature is

    // public operator fun <T> Collection<T>.plus(elements: Iterable<T>): List<T>

    // You can also jump into the whole implementation by Strg+Click on the plus icon.

    // Kotlin has also introduced an extension property to the List interface.
    println(list1.lastIndex)

    // The implementation/definition has the following syntax:

    // public val <T> List<T>.lastIndex: Int
    //    get() = this.size - 1

    // The syntax is the same as when you customize getter and setter of a variable.
    // However since extension properties are implemented via static utility functions, you cannot really add an extra field to the existing class.
    // Hence, the setter has to work with already existing fields.
}