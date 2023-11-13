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
 */
fun main() {
    // In Kotlin, you can define "instance methods" of classes outside of those classes, so-called extension functions.
    fun List<Int>.multiplyEachBy(factor: Int): List<Int> {
        return this.map {
            it * factor
        }
    }

    val simpleSuccession = listOf(1, 2, 3)
    println(simpleSuccession.multiplyEachBy(10))
}
