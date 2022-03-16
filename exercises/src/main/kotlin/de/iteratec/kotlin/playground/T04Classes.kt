package de.iteratec.kotlin.playground

/*
Requirements:
- Topic1_Functions
- Topic3_MutabilityAndExpressions

Things to explain as instructor:
- Constructor
- Attributes
- Instantiation
 */

// This is SimpleClassJava converted to Kotlin.
//
// Properties of a Kotlin class can be declared as val or var.
// Kotlin automatically creates a getter, setter and private backing field for var.
// Kotlin automatically creates a getter and private backing field for val.
//
// Kotlin forces you to define the signature of the arguments of your so-called primary constructor next to the class name
// Content of init blocks and variable assignments in property definitions inside the class body form the body of this constructor.
private class SimpleClass constructor(readOnlyProperty: String, mutableProperty: Int) {
    var readOnlyProperty: String = readOnlyProperty
    var mutableProperty: Int = mutableProperty

    init {
        println("In constructor")
    }

    fun instanceMethod() {
        println(this)
    }
}

private class SimpleClassBestPractice (val readOnlyProperty: String, var mutableProperty: Int) {
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

    yourFirstClass()
}

// ---- Try it yourself!

/**
 * Task yourFirstClass
 * Create a class 'Dog' with read-only property 'name' (String) and mutable property 'weight' (Int) defined in the constructor.
 * Then create an instance of a Dog and print both properties.
 * Add a default value 500 for the property 'weight' in the constructor.
 * Optional: Add a method gainWeight to the class that doubles the weight of a horse.
 */
private fun yourFirstClass() {
    println("#### Task YourFirstClass")
}