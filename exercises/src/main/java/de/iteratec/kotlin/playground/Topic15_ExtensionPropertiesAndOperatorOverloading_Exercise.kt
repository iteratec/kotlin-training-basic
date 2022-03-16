package de.iteratec.kotlin.playground

fun main() {
    // Kotlin allows not only to define extension functions but also extension properties. Another exotic feature is to overload commonly used operators like "!" or "+".
    // These features are mainly used to write Domain-Specific languages in Kotlin, but can be useful from time to time.

    val list1 = listOf("element1")
    val list2 = listOf("element2")
    val joinedList = list1 + list2
    println(joinedList)

    // The + operator is overloaded for the Collection interface. In order t overload a particular operator, you need to
    // define a function using the "operator" keyword and certain function name representing the operator.
    // For lists the signature is

    // public operator fun <T> Collection<T>.plus(elements: Iterable<T>): List<T>

    // You can also jump into the whole implementation by Strg+Click on the plus icon.

    // Kotlin has only introduced an extension property to the List interface.
    println(list1.lastIndex)

    // The implementation/definition has the following syntax:

    // public val <T> List<T>.lastIndex: Int
    //    get() = this.size - 1

    // In principal extension properties can aso have a
    // set(type: Type) = run { ... }
    // block. However since extension properties are implemented via static utility functions, you cannot really add an extra field to the existing class.
    // Hence, the setter has to work with already existing fields.

    // Try it yourself
    taskExtensionProperties()
    taskOperatorOverloading()
}

/**
 * taskExtensionProperties
 * Add an extension property kelvin to temperature in order to read/write the temperature in Kelvin.
 */
fun taskExtensionProperties() {
    println("#### Task taskExtensionProperties")
    val temperature = Temperature(10f)
/*    temperature.kelvin = 300f
    println(temperature.kelvin)*/
    println(temperature)
}

/**
 * taskExtensionProperties
 * Add overator overloading to Temperature such that -temperature alternates the sign of the degree in celsius (the name of the function has to be unaryMinus).
 */
fun taskOperatorOverloading() {
    println("#### Task taskOperatorOverloading")
    val temperature = Temperature(10f)
    // println(-temperature)
}

data class Temperature(
    var celsius: Float
)
