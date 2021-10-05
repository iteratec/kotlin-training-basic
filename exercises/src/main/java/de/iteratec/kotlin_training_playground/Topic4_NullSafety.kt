package de.iteratec.kotlin_training_playground

import java.util.*
import kotlin.random.Random


// nullable
// ?. ?: !!
// platform types & nullable annotations

fun main() {
    val catName: String = "Katy Purry"
    val dogName: String? = "Bark Twain"
    println("cat = " + catName)
    println("dog = " + dogName)

    simpleNullCheck()
    taskElvisAndSafeCall()
    task3()
    task4()
}

// ---- Try it yourself!

/**
 * Task simpleNullCheck
 * Uncomment the following line. Does it compile? Wrap the code inside a null check using an if-statement to execute printArgument only if couldBeNullOrString is not null.
 * This null-check is a good opportunity to inform you about equality in Kotlin:
 * The "==" operator corresponds to calling ".equals()". The operator "===" compares objects by looking at which part of the memory they reference ("==" in Java)
 */
private fun simpleNullCheck() {
    println("#### Task simpleNullCheck")

    val couldBeNullOrString: String? = "i could be null"

    // printArgumentToConsole(couldBeNullOrString)

    // Now change couldBeNullOrString to be a "var". Your code most likely does not compile anymore. Why? That is really annoying but we will learn about a good and more concise way to do this null check later.
}

private fun printArgumentToConsole(nonNullableInput: String) {
    println(nonNullableInput)
}


/**
 * Task ElvisAndSafeCall
 * Rewrite the code using the safe call operator ?. and Elvis operator ?:
 */
private fun taskElvisAndSafeCall() {
    println("#### Task ElvisAndSafeCall")

    val dogName: String? = if (Random.nextBoolean()) "Rocky" else null

    // change this code:
    if (dogName != null) {
        println(dogName.first())
    } else {
        println("")
    }
}


/**
 * Task 3
 * Uncomment the code & see what happens 😉 (then: how do we fix this?)
 */
private fun task3() {
    println("#### Task 3")

    val scanner = Scanner(">> only Rocky is here <<")
    val lucy = scanner.findInLine("lucy")
//    val firstLetter = lucy.first()
//    println(firstLetter)
}


/**
 * Task 4
 * This example has the same problem as task3. However, this time we own the Java code ourself and we can guarantee that
 * the Java function does not return null. Adapt the Java class in such a way that it returns a proper string and that
 * Kotlin is really secure that the Java call does not return null.
 */
private fun task4() {
    println("#### Task 4")

    val javaStringEmitter = StringEmitter()
    val suspiciousStringFromJavaCall = javaStringEmitter.giveMeAString()
    printArgumentToConsole(suspiciousStringFromJavaCall)
}
