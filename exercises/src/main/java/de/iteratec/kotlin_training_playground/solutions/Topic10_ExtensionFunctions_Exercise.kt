package de.iteratec.kotlin_training_playground.solutions

fun String?.replaceUmlaute(): String = this
    ?.replace("ä", "ae")
    ?.replace("ö", "oe")
    ?.replace("ü", "ue")
    ?.replace("ß", "ss")
    ?: ""

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

    extensionFunction()
    extensionFunctionAndNullSafety()
}

/**
 * Task extensionFunction
 * Rewrite replaceUmlauteInString to be an extension function of String such that the code compiles and prints "Traenenueberstroemter Strauss".
 */
fun extensionFunction() {
    println("#### Task extensionFunction")
    val myString = "Tränenüberströmter Strauß"

    println(myString.replaceUmlaute())
}

/**
 * Rewrite replaceUmlauteInString to be able to being called on null (returning an empty string in this case).
 */
fun extensionFunctionAndNullSafety() {
    println("#### Task extensionFunctionAndNullSafety")
    val nullInsteadOfAString = null

    println("" == null.replaceUmlaute())
}



