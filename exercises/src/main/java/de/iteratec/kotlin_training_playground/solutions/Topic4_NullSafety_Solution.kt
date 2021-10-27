package de.iteratec.kotlin_training_playground.solutions

import java.util.*
import kotlin.random.Random

fun main() {
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

    // Kotlin does smart casts when it is sure a nullable instance is not null
    if (nullableString != null) {
        println(nullableString.length)
    }

    // In case you are sure some nullable element is different null, you can cast it
    println(nullableString!!.length)

    // Try it yourself
    nullablePropertiesInClasses()
    taskElvisAndSafeCall()
    platformTypes()
    gettingRidOfPlatformTypes()
}

// ---- Try it yourself!

class ExampleClass(
    var optionalProperty: String?,
) {
    fun returnOptionalPropertyAsString(): String {
        return optionalProperty ?: ""
    }
}

/**
 * Task nullableValuesInClasses
 * ExampleClass is using the Java system of null-safety, the Optional-wrapper. Replace it by a nullable String
 * and refactor its usages?
 * Why is the Kotlin way better than using an Optional?
 */
private fun nullablePropertiesInClasses() {
    println("#### Task nullableValuesInClasses")
    val instance = ExampleClass(null)
    if (instance.optionalProperty != null) {
        println("Poor instance of our class. Its optionalProperty is empty.")
    }
    instance.optionalProperty = "something"
    if (instance.optionalProperty?.startsWith("s") == true) {
        println("Instance of our class has optionalProperty starting with s")
    }
}

/**
 * Task ElvisAndSafeCall
 * Rewrite the code using the safe call operator ?. and Elvis operator ?:
 */
private fun taskElvisAndSafeCall() {
    println("#### Task ElvisAndSafeCall")

    val dogName: String? = if (Random.nextBoolean()) "Rocky" else null

    println(dogName?.first() ?: "-")
}

/**
 * Task platformTypes
 *
 * As Java is not null-safe, Kotlin would have to assume that all returns of Java functions are nullable.
 * However, this would basically prevent us to use non-nullable types at all when working with Java and Kotlin.
 * As a compromise, Java functions return so-called platform types (String!, Int!, ...), which cannot be defined by hand.
 * Platform type behave more or less like non-nullable types but can throw a NullPointerException on unsafe access.
 * You can assign platform values to nullable or non-nullable variables.
 *
 * Uncomment the code & see what happens 😉. What is the inferred type of lucy (Strg + Q)? (then: how do we fix this?)
 */
private fun platformTypes() {
    println("#### Task platformTypes")

    val scanner = Scanner(">> only Rocky is here <<")
    val lucy: String? = scanner.findInLine("lucy")
    val firstLetter = lucy?.first()
    println(firstLetter)
}


/**
 * Task gettingRidOfPlatformTypes
 * This example has the same problem as platformTypes. However, this time we own the Java code ourself. Change the Java class
 * by using the @Nullable annotation in such a way that the code below does not compile anymore
 * and Kotlin forces you to handle the possibilty of null.
 */
private fun gettingRidOfPlatformTypes() {
    println("#### Task gettingRidOfPlatformTypes")

    val javaStringEmitter = StringEmitter()
    val suspiciousStringFromJavaCall = javaStringEmitter.giveMeAString()
    println(suspiciousStringFromJavaCall?.first())
}
