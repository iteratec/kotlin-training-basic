package de.iteratec.kotlin_training_playground

import java.util.*

// nullable
// ?. ?: !!
// platform types

fun main() {
    val catName: String = "Katy Purry"
    val dogName: String? = "Bark Twain"
    println("cat = $catName, dog = $dogName")

    task1()
    task2()
}


// ---- Try it yourself!


/**
 * Task 1
 * Rewrite the code using the safe call operator ?. and Elvis operator ?:
 */
private fun task1() {
    println("#### Task 1")

    val dogName: String? = if (Random().nextBoolean()) "Rocky" else null

    // change this code:
    if (dogName != null) {
        println(dogName.first())
    } else {
        println("")
    }
}

/**
 * Task 2
 * Uncomment the code & see what happens 😉 (then: how do we fix this?)
 */
private fun task2() {
    println("#### Task 2")

    val scanner = Scanner(">> only Rocky is here <<")
    val lucy = scanner.findInLine("lucy")
//    val firstLetter = lucy.first()
//    println(firstLetter)
}
