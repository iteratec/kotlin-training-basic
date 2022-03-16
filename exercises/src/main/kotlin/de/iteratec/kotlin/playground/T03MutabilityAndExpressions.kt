package de.iteratec.kotlin.playground

/**
 # Mutability & expressions

 Requirements:
 - Functions

 Things to discuss:
 - val/var
 - Type-inference for variables
 - Expressions in Kotlin
 */
fun main() {

    // Variables defined with the "val" keyword are read-only (similar to final in Java). Reassignment is impossible.
    val readOnlyStringVariable: String = "string"
    // Reassignment would result in a compilation error.
    // readOnlyString = "reassigned"

    // Variables defined with the "var" keyword can be reassigned.
    var mutableStringVariable: String = "string"
    mutableStringVariable = "reassigned"
    println(mutableStringVariable)

    // Type String is auto-inferred (Press Ctrl + Q to show the type)
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
}
