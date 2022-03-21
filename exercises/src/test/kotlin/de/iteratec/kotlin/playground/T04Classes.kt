package de.iteratec.kotlin.playground

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
 */

// This is SimpleClassJava converted to Kotlin.
//
// Properties of a Kotlin class can be declared as val or var.
// Kotlin automatically creates a getter, setter and backing field for var.
// Kotlin automatically creates a getter and private backing field for val.
//
// Kotlin forces you to define the signature of the arguments of your so-called primary constructor next to the class name
// Content of init blocks and variable assignments in property definitions inside the class body form the body of this constructor.
class SimpleClass constructor(readOnlyProperty: String, mutableProperty: Int) {
    val readOnlyProperty: String = readOnlyProperty
    var mutableProperty: Int = mutableProperty

    init {
        println("In constructor")
    }

    fun instanceMethod() {
        println(this)
    }
}

class SimpleClassBestPractice (val readOnlyProperty: String, var mutableProperty: Int) {
    init {
        println("In constructor")
    }

    fun instanceMethod() {
        println(this)
    }
}

fun main() {
    // There is no "new" keyword in Kotlin
    val simpleClass = SimpleClass("readOnly", 0)
    val simpleClassBestPractice = SimpleClassBestPractice("readOnly", 0)

    // Behind the scenes a getter is called. The fields themselves are private, however for the client it seems like we access them directly.
    println(simpleClass.readOnlyProperty)
    println(simpleClassBestPractice.readOnlyProperty)

    //Behind the scenes a setter is called.
    simpleClass.mutableProperty = 10
    simpleClassBestPractice.mutableProperty = 10

    // Compile error because for "val" no setters are generated:
    // simpleClass.readOnlyProperty = "reassigned"

    simpleClass.instanceMethod()
    simpleClassBestPractice.instanceMethod()
}
