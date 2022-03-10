package de.iteratec.kotlin_training_playground.solutions

fun main() {

    // Variables defined with the "val" keyword are read-only (similar to final in Java). Reassignement is impossible.
    val readOnlyStringVariable: String = "string"
    // Reassignment would be a compile failure.
    // readOnlyString = "reassigned"

    // Variables defined with the "var" keyword can be reassigned.
    var mutableStringVariable: String = "string"
    mutableStringVariable = "reassigned"
    println(mutableStringVariable)

    // Type String is auto-inferred (Press Strg + Q to show the type)
    val autoInferredString = "auto-inferred"

    // Many keyword-constructions in Kotlin are expressions meaning they return a value (usually the expression inside evaluated last)
    val resultOfIfExpression: String = if (true) {
        println("In true branch")
        "true"
    } else {
        println("In false branch")
        "false"
    }

    // If also has a short one-liner form.
    val resultOfConciseIfExpression: String = if (true) "true" else "false"

    // Try it yourself

    task1()
    task2()
    task3()
}

/**
 * Task 1
 * Uncomment the line and fix the code, so it prints 'Lucy'
 */
private fun task1() {
    println("#### Task 1: Should print Lucy")

    var catName = "Lisa"
    catName = "Lucy"
    println(catName)
}

/**
 * Task 2
 * Uncomment the line and fix the code, so it prints 'Lucy'
 */
private fun task2() {
    println("#### Task 2: Should print Lucy")

    var catName: Any = 7
    catName = "Lucy"
    println(catName)
}

/**
 * Task 3
 * Use the fact that "try" is a expressions to directly assign the variable riskyComputationResult without declaring it first
 */
private fun task3() {
    println("#### Task 4: Should print riskyComputation failed")

    val riskyComputationResult: String = try {
        0 / 0
        "succeeded"
    } catch (e: Exception) {
        "failed"
    }

    println("riskyComputation " + riskyComputationResult)
}
