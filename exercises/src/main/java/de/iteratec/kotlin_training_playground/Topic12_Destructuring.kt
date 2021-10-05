package de.iteratec.kotlin_training_playground

enum class TypeOfSave {
    NEW, UPDATE
}

fun createOrUpdate() {
}

fun main() {
    multipleReturnValuesFromAFunction()
    implementingDestructuring()
}

/**
 * Task multipleReturnValuesFromAFunction
 * Sometimes, we want a function to return multiple values without introducing a lot of boilerplate by creating a class representing the return type that is longer than one line.
 * Change the signature of createOrUpdate to return a "Pair" and provide the implementation such that the code below compiles and the test is green.
 */
fun multipleReturnValuesFromAFunction() {
    println("#### Task multipleReturnValuesFromAFunction")
/*        val (success, typeOfSave) = createOrUpdate()
        println(success)
        println(typeOfSave) */
}

/**
 * Task implementingDestructuring
 * Strings do not offer destructuring. Implement destructuring for strings in the sense that the first component of the destructuring declaration is the first letter of the string.
 */
fun implementingDestructuring() {
    println("#### Task implementingDestructuring")
/*        val ( first ) = "hallo"
        println(first)*/
}