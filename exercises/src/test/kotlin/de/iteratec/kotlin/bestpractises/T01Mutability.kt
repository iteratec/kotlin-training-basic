package de.iteratec.kotlin.bestpractises

import de.iteratec.kotlin.playground.random
import kotlin.random.Random

/**
 * # avoid Mutability
 *
 * - use val instead of var
 * - use read-only collections instead of mutable collections
 * - use data class for pure data objects
 *
 */

class User(var name: String, var email: String)

fun main() {
    var user = User("John Doe", "jon.doe@kotlin.course.com")
    user.email = "john.doe@kotlin.training.com"

    var newUser = getUser()

    if (newUser == null) {
        newUser = User("default user", "")
    }

    var trainings = mutableListOf("kotlin-basics", "kotlin-advanced")
    trainings.add("kotlin-best-practises")

    println(user)
    println(newUser)
    println(trainings)
}


fun getUser(): User? {
    if (Random(1).nextBoolean()) {
        return User("Joe Random", "joe.random@guess.what")
    }
    return null
}