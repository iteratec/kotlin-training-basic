package de.iteratec.kotlin.playground

/**
 # Extension functions
 Requirements:
 - Functions
 - NullSafety

 Things to discuss:
 - Syntax for extension functions
 - Scope & resolution of extension functions
 - Use cases of extension functions
 */
fun main() {
    // In Kotlin, you can define "instance methods" of classes outside of those classes, so-called extension functions.
    // However extension functions are compiled into static methods of utility classes. Hence they do not behave polymorphic.
    fun List<Int>.multiplyEachBy(factor: Int): List<Int> {
        return this.map {
            it * factor
        }
    }

    val simpleSuccession = listOf(1, 2, 3)
    println(simpleSuccession.multiplyEachBy(10))
}
