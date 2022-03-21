package de.iteratec.kotlin.playground

import org.junit.Test
import java.util.*
import kotlin.random.Random

class NullSafetyTasks {

    class ExampleClass(var optionalProperty: Optional<String>) {
        fun returnOptionalPropertyAsString(): String {
            return optionalProperty.orElse("")
        }
    }

    /**
     * ## Nullable values in classes
     * ExampleClass is using the Java system of null-safety, the Optional-wrapper. Replace it by a nullable String
     * and refactor its usages.
     * Why is the Kotlin way better than using an Optional?
     */
    @Test
    fun nullablePropertiesInClasses() {
        val instance = ExampleClass(Optional.empty())
        if (instance.optionalProperty.isEmpty()) {
            println("Poor instance of our class. Its optionalProperty is empty.")
        }
        instance.optionalProperty = Optional.of("something")
        if (instance.optionalProperty.isPresent && instance.optionalProperty.get().startsWith("s")) {
            println("Instance of our class has optionalProperty starting with s")
        }
    }

    /**
     * ## Elvis and safe-call operators
     * Rewrite the code using the safe call operator ?. and Elvis operator ?:
     */
    @Test
    fun taskElvisAndSafeCall() {
        val dogName: String? = if (Random.nextBoolean()) "Rocky" else null

        // Change this code:
        if (dogName != null) {
            println(dogName.first())
        } else {
            println("-")
        }
    }

    /**
     * ## Platform types
     *
     * As Java is not null-safe, Kotlin would have to assume that all returns of Java functions are nullable.
     * However, this would basically prevent us to use non-nullable types at all when working with Java and Kotlin.
     * As a compromise, Java functions return so-called platform types (String!, Int!, ...), which cannot be defined by
     * hand. Platform type behave more or less like non-nullable types but can throw a NullPointerException on unsafe
     * access. You can assign platform values to nullable or non-nullable variables.
     *
     * Execute the test & see what happens 😉.
     * What is the inferred type of lucy (Strg + Q)? How can we fix this?
     */
    @Test
    fun platformTypes() {
        val scanner = Scanner(">> only Rocky is here <<")
        val lucy = scanner.findInLine("lucy")
        val firstLetter = lucy.first()
        println(firstLetter)
    }

    /**
     * ## Getting rid of platform types
     * This example has the same problem as platform types. However, this time we own the Java code ourselves.
     * Change the Java class by using the @Nullable annotation in such a way that the code below does not compile
     * anymore and Kotlin forces you to handle the possibility of null.
     */
    @Test
    fun gettingRidOfPlatformTypes() {
        val javaStringEmitter = T05NullSafetyJava()
        val suspiciousStringFromJavaCall = javaStringEmitter.giveMeAString()
        // println(suspiciousStringFromJavaCall.first())
    }
}
