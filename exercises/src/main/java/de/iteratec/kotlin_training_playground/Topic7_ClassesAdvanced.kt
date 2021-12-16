package de.iteratec.kotlin_training_playground

import java.io.Serializable

fun main() {
    // When you want to inherit from a class, you specify the parent class directly behind the definition of your primary constructor separated by ":".
    // More specifically, you specify a constructor call to your parent class. This constructor call becomes the first line of the body of the primary constructor of your subclass.
    // Inheriting from an interface is simpler since interfaces do not have constructors and you only have to supply the name of the interface.
    class MyCustomRuntimeException(message: String): RuntimeException(message), Serializable {
        override fun toString(): String {
            return "Great! MyCustomRuntimeException happened with message: ${message}"
        }
    }

    val runtimeException: RuntimeException = MyCustomRuntimeException("Panic mode activated!")

    // In Kotlin, there are no static properties/methods. They are replaced by the concept of a companion object. See ClassWithStaticMethod as an example.
    // The companion object is a singleton instance of an anonymous inner class that is created automatically if existing.
    // The important point is that the he companion object is available under the same namespace as the origin class itself.
    // Hence (accesses to properties)/(invocations of methods) of the companion object behave exactly like (accesses to static properties)/(accesses to static methods) of the origin class would do.
    // Declarations inside the origin class itself can reference properties/methods of the companion object.

    ClassWithStaticMethod.printCountOfExistingInstances()
    val instance1 = ClassWithStaticMethod()
    ClassWithStaticMethod.printCountOfExistingInstances()
    val instance2 = ClassWithStaticMethod()
    ClassWithStaticMethod.printCountOfExistingInstances()

    inheritance()
    companionObject()
    dataClass()
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

// ---- Try it yourself!

/**
 * Task inheritance
 * Make IteratecEmployee inherit Employee and override the method such that it prints "Heiko likes his/her job. But holiday is still better ;)".
 * The open keyword means that things can be subclassed/overidden. By default classes/methods/properties cannot be overidden.
 */
private fun inheritance() {
    println("Task inheritance: Should print: Heiko likes his/her job. But holiday is still better ;)")
    open class Employee(val name: String) {
        open fun getStatus() = "$name hates his/her job and longs for holiday"
    }

    class IteratecEmployee(val name: String) {
        fun getStatus() = "$name likes his/her job. But holiday is still better ;)"
    }

/*        val employee: Employee = IteratecEmployee("Heiko")
        println(employee.getStatus())*/
}

class Horse(val name: String, val weight: Int = 500)
data class HorseAsDataClass(val name: String, val weight: Int = 500)

/**
 * Task dataClass
 * Data classes are classes for which equals, hashCode and toString are auto-implemented.
 * They also offer a copy-method that allows to generate new instances from existing ones.
 * Try to understand the following log-lines.
 */
private fun dataClass() {
    println("#### Task dataClass")
    val horse1 = Horse("Albrecht Traber", 8)
    val horse2 = Horse("Albrecht Traber", 8)
    println(horse1 == horse2)
    println(listOf(horse1).contains(horse2))
    println(horse1)
    val horse1AfterMarriage = Horse("Albrecht Blondmähne", horse1.weight)
    println(horse1AfterMarriage)

    val horse3 = HorseAsDataClass("Albrecht Traber", 8)
    val horse4 = HorseAsDataClass("Albrecht Traber", 8)
    println(horse3 == horse3)
    println(listOf(horse3).contains(horse4))
    println(horse4)
    val horse3AfterMarriage = horse3.copy(name = "Albrecht Blondmähne")
    println(horse3AfterMarriage)
}

/**
 * Task companion object
 */
private fun companionObject() {
    println("#### Task companionObject")
    // Implement a "static" builder function for the Horse class using a companion object such that the test code below compiles and constructs the right horse
    // val horse = Horse.builder().withName("Trabi").withWeight(10).build()
    // println(horse.name)
    // println(horse.weight)
}