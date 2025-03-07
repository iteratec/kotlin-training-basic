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
    // An object is a class with parameterless constructor for which a singleton instance is created automatically.
    println(MyStringUtils.sortedByAlphabet("cba"))

    // Objects can implement interfaces or other classes.
    println(DevConfiguration.url)

    // In Kotlin, there are no static properties/methods. They are replaced by the concept of a companion object.
    // The companion object is basically an object associated with a regular class.
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

// please do not do this
class Singleton private constructor() {

    fun myShinyMethod() {
        println("method")
    }
    companion object {
        var instance: Singleton? = null
            get() {
                return if (field == null) {
                    instance = Singleton()
                    field
                } else {
                    field
                }
            }
    }
}



