package de.iteratec.kotlin.basic

/**
# Classes advanced
Requirements:
- Classes

Things to discuss:
- Objects and their use-cases
- Companion object
 */
fun main() {
    // An object is a class with parameterless constructor for which a singleton is instantiated automatically.
    // No other instances can be instantiated.
    // The name of the object class is rewired to be a reference to the singleton
    println(MyStringUtils.sortedByAlphabet("cba"))

    // Objects can implement interfaces or other classes.
    println(DevConfiguration.url)

    // In Kotlin, there are no static properties/methods. They are replaced by the concept of a companion object.
    // The companion object is basically an object with no name declared in a class body
    // The resulting singleton instance is available under the same namespace as the origin class itself.
    // Hence, accesses to properties and invocations of methods of the companion object behave exactly like accesses to
    // static properties and accesses to static methods of the origin class would do.
    // Declarations inside the origin class itself can reference properties/methods of the companion object.
    ClassWithStaticMethod.printLeader()
    val instance = ClassWithStaticMethod()
    instance.promoteToLeader()
    ClassWithStaticMethod.printLeader()
}

object MyStringUtils {
    fun sortedByAlphabet(input: String): String {
        return input.toList().sorted().joinToString("")
    }
}

abstract class DatabaseConfiguration(
    val url: String,
) {
    abstract fun buildAuthorizationHeaderContent(): String?
}

object DevConfiguration : DatabaseConfiguration("localhost:3000") {
    override fun buildAuthorizationHeaderContent(): String? = null
}

class ClassWithStaticMethod {
    fun promoteToLeader() {
        leader = this
    }

    companion object {
        private var leader: ClassWithStaticMethod? = null
        fun printLeader() {
            if (leader == null) {
                println("No leader at the moment.")
            } else {
                println("Leader is $leader")
            }
        }
    }
}

