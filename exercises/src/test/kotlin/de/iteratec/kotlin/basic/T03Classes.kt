package de.iteratec.kotlin.basic

/**
 # Classes
 Requirements:
 - Functions
 - Mutability and expressions

Things to discuss:
 - Primary & secondary constructors
 - Properties
 - Shorthand for properties in constructor
 - Instantiation
 - Default parameters in constructors
 - Visibility modifiers
 */

// See SimpleClassJava in T03ClassesJava for Java variant of this class.
class SimpleClass(readOnlyProperty: String, mutableProperty: String) {
    val readOnlyProperty: String = readOnlyProperty
    var mutableProperty: String = mutableProperty

    init {
        println("In constructor")
    }

    fun instanceMethod() {
        println(this)
    }
}

class SimpleClassBestPractice (val readOnlyProperty: String, var mutableProperty: String) {
    init {
        println("In constructor")
    }

    fun instanceMethod() {
        println(this)
    }
}

fun main() {
    // There is no "new" keyword in Kotlin
    val simpleClass = SimpleClass("readOnly", "mutable")

    // Behind the scenes a getter is called. The fields themselves are private, however for the client it seems like we access them directly.
    println(simpleClass.readOnlyProperty)

    //Behind the scenes a setter is called.
    simpleClass.mutableProperty = "changed"

    // Compile error because for "val" no setters are generated:
    // simpleClass.readOnlyProperty = "reassigned"

    simpleClass.instanceMethod()
}