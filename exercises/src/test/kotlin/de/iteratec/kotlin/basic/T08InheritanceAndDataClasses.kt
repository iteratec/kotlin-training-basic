package de.iteratec.kotlin.basic

import java.io.Serializable

/**
 # Inheritance and data classes
 Requirements:
 - Classes

 Things to discuss:
 - Inheritance basic syntax
 - open keyword
 - Overwriting methods
 - Customizing getters and setters
 - Data classes
 */
fun main() {
    // When you want to inherit from a class, you specify the parent class directly behind the definition of your
    // primary constructor separated by ":". More specifically, you specify a constructor call to your parent class.
    // This constructor call becomes the first line of the body of the primary constructor of your subclass. Inheriting
    // from an interface is simpler since interfaces do not have constructors, and you only have to supply the name of
    // the interface.
    class MyCustomRuntimeException(message: String): RuntimeException(message), Serializable {
        override fun toString(): String {
            return "Great! MyCustomRuntimeException happened with message: $message"
        }
    }

    val runtimeException: RuntimeException = MyCustomRuntimeException("Panic mode activated!")
    println(runtimeException)

    // Kotlin generates setters and getters automatically for properties however we can customize them.
    class ClassUnderSurveillance() {
        var content: String = "Content"
            get() {
                // "field" behaves like a keyword and refers to the backing field behind the property.
                println("Surveillance: Class content with value $field has been accessed")
                return field
            }
            set(value: String) {
                // "field" behaves like a keyword and refers to the backing field behind the property.
                field = value
                println("Surveillance: Class content has been set to $value")
            }
    }

    val instanceUnderSurveillance = ClassUnderSurveillance()
    instanceUnderSurveillance.content = "New"
    instanceUnderSurveillance.content

    // So-called Data classes already come with built-in implementations of equals, hashCode (both by comparing all properties), toString and a useful copy-functionality.
    data class Name(
        val title: String?,
        val firstName: String,
        val middleName: String?,
        val lastName: String
    )

    val name = Name("Dr. med", "Marlene", null, "Hippokrates")
    println(name)
    val nameAfterMarriage = name.copy(lastName = "Asklepios")
    println(nameAfterMarriage)
}
