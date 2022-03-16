package de.iteratec.kotlin.playground

import java.io.Serializable

/**
 # Classes advanced
 Requirements:
 - Classes

 Things to discuss:
 - Inheritance basic syntax
 - open keyword
 - Overwriting methods
 - Companion objects
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
            return "Great! MyCustomRuntimeException happened with message: ${message}"
        }
    }

    val runtimeException: RuntimeException = MyCustomRuntimeException("Panic mode activated!")

    // In Kotlin, there are no static properties/methods. They are replaced by the concept of a companion object.
    // See ClassWithStaticMethod as an example. The companion object is a singleton instance of an anonymous inner class
    // that is created automatically if existing.
    // The important point is that the companion object is available under the same namespace as the origin class itself.
    // Hence, accesses to properties and invocations of methods of the companion object behave exactly like accesses to
    // static properties and accesses to static methods of the origin class would do.
    // Declarations inside the origin class itself can reference properties/methods of the companion object.
    ClassWithStaticMethod.printCountOfExistingInstances()
    val instance1 = ClassWithStaticMethod()
    ClassWithStaticMethod.printCountOfExistingInstances()
    val instance2 = ClassWithStaticMethod()
    ClassWithStaticMethod.printCountOfExistingInstances()
}

class ClassWithStaticMethod {
    init {
        countOfExistingInstances = countOfExistingInstances + 1
    }

    companion object {
        var countOfExistingInstances = 0
        fun printCountOfExistingInstances() {
            println("For ClassWithStaticMethod $countOfExistingInstances many instances have been instantiated")
        }
    }
}
