package de.iteratec.kotlin.basic

/**
 # Lambdas & function types
 Requirements:
 - Functions
 - Mutability and expressions
 - Collections and Lambdas

 Things to discuss:
 - Function types
 - Lambda convention
 - Scope functions
 */


fun main() {
    // You can save lambdas into variables and use them in any place where you can use variables.
    // Note that the brackets belong to the declaration of the lambda. The last line evaluated in a lambda gets returned automatically.
    class Woman(val generation: Int)

    val getMotherOf: (Woman) -> Woman? = {
        val generation = it.generation
        if (generation < 5) {
            Woman(generation + 1)
        } else {
            null
        }
    }

    // With a changed invocation we could get the grandmother. However the possibility of null is annoying.
    val woman = Woman(0)
    val mother = getMotherOf(woman)
    val grandmother = if (mother != null) getMotherOf(mother) else null

    // If getMotherOf was an instance method of Woman, we could use the safe-call operator ?.
    // val grandmother = woman.getMother()?.getMother()

    // Kotlin allows us to use to solve our initial problem with the "let"-function.
    // Imagine "let" to be a counterpart of the "map" function from collections for single objects.
    val grandmotherWithLet = getMotherOf(woman)?.let { getMotherOf(it) }
}
