package de.iteratec.kotlin.basic

/**
 # Extension functions
 Requirements:
 - Functions
 - Null-safety

 Things to discuss:
 - Syntax for extension functions
 - Scope & resolution of extension functions
 - Extension functions in bytecode
 - Use cases of extension functions
 - Best practices: Shadowed functions / properties
 */

// In Kotlin, you can define "instance methods" of classes outside of those classes, so-called extension functions.
fun List<Int>.multiplyEachBy(factor: Int): List<Int> {
    return this.map {
        it * factor
    }
}

fun main() {
    val simpleSuccession: List<Int> = listOf(1, 2, 3)
    println(simpleSuccession.multiplyEachBy(10))

    MyShinyProperties().myMethod()
}

class MyShinyProperties {
    val publicProperty: Int = 2
    internal val internalProperty: String = ""
    protected val protectedProperty: String = ""
    private val property: String = ""

    // Which method will be executed?
    fun myMethod() {
        println("instance")
    }
}

// Which method will be executed?
fun MyShinyProperties.myMethod() {
    println("extension")

    // Only public / internal properties of the extended class are visible in extension functions
    this.publicProperty
    this.internalProperty

    // Does not compile
//    this.protectedProperty
//    this.property
}
