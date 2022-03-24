package de.iteratec.kotlin.playground

import java.util.*

/**
 # Null safety
 Requirements:
 - Functions
 - Mutability and expressions
 - Classes

 Things to discuss:
 - Null-safety in Kotlin
 - Safe-call and Elvis operators & chaining
 - Smart casts
 - Double-bang operator
 - Platform types (TODO: Introduce platform types without going to deep into problems and solutions)
 */
fun main() {
    // Kotlin is null-safe. In a variable of type Type we cannot save "null". In a variable of type "Type?" we can assign "null".
    val nonNullableString: String = "definitelyNotNull"
    val nullableString: String? = "couldBeNull"
    val nullDisguisedAsString: String? = null

    // In general, methods cannot be called on nullable variables without precaution.
    // The safe-call operator ?. only calls the receiver when it is different from null and returns null otherwise.
    println(nonNullableString.length)
    println(nullableString?.length)
    println(nullDisguisedAsString?.length)

    // One can chain multiple safe-call operators.
    println(nonNullableString.length.minus(1))
    println(nullableString?.length?.minus(1))
    println(nullDisguisedAsString?.length?.minus(1))

    // The Elvis operator can be used to replace nulls
    println(nonNullableString.length)
    println((nullableString ?: "").length)
    println((nullDisguisedAsString ?: "").length)

    // The safe-call operator can be combined with the Elvis operator to get a non-nullable result
    println(nonNullableString.length.minus(1))
    println(nullableString?.length?.minus(1) ?: -1)
    println(nullDisguisedAsString?.length?.minus(1) ?: -1)

    // Kotlin does smart casts when it's certain that a variable is not null
    if (nullableString != null) {
        println(nullableString.length)
    }

    // Developers may cast a nullable type to a non-nullable type
    println(nullableString!!.length)

    // Platform types (here String!) result from Java calls where Kotlin is not sure whether the type is nullable or not.
    // Kotlin compiler does not do null checks on variables of platform type. We can assign a an expression of platform type
    // to a nullable variable or a non-nullable variable
    val scanner = Scanner(">> only Rocky is here <<")
    val autoInferredPlatformType = scanner.findInLine("Lucy")
    val assignedToNonNullableType: String = scanner.findInLine("Lucy")
    val assignedToNullableType: String? = scanner.findInLine("Lucy")
}
