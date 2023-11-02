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

// This is SimpleClassJava converted to Kotlin.
//
// Properties of a Kotlin class can be declared as val or var.
// Kotlin automatically creates a getter, setter and private backing field for var.
// Kotlin automatically creates a getter and private backing field for val.
//
// Kotlin forces you to define the signature of the arguments of your so-called primary constructor next to the class name
// Content of init blocks and variable assignments in property definitions inside the class body form the body of this constructor.
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
