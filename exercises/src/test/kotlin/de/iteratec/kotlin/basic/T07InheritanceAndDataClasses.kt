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
    // Kotlin supports single inheritance. You can specify the base class and interfaces after a colon.
    // Note, that you always have to call the constructor of the base class.
    class MyCustomRuntimeException(message: String) : RuntimeException(message), Serializable {
        override fun toString(): String {
            return "Great! MyCustomRuntimeException happened with message: $message"
        }
    }

    val runtimeException: RuntimeException = MyCustomRuntimeException("Panic mode activated!")
    println(runtimeException)

    // Kotlin generates setters and getters automatically, but you can customize them.
    class LoggedAccess() {
        var content: String = "Content"
            get() {
                // "field" behaves like a keyword and refers to the backing field behind the property.
                println("Surveillance: Class content with value $field has been accessed")
                return field
            }
            set(value: String) {
                field = value
                println("Surveillance: Class content has been set to $value")
            }
    }

    val loggedAccess = LoggedAccess()
    loggedAccess.content = "New"
    loggedAccess.content

    // Data classes come with built-in implementations of equals, hashCode (both by comparing all properties), toString
    // and a useful copy-functionality.
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
