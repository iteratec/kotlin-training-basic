package de.iteratec.kotlin_training_playground

fun replaceUmlaute(input: String): String = input
    .replace("ä", "ae")
    .replace("ö", "oe")
    .replace("ü", "ue")
    .replace("ß", "ss")


fun main() {
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

    // println(myString.replaceUmlaute())
}

/**
 * Rewrite replaceUmlauteInString to be able to being called on null.
 */
fun extensionFunctionAndNullSafety() {
    println("#### Task extensionFunctionAndNullSafety")
    val nullInsteadOfAString = null

    // println("" == null.replaceUmlaute())
}



