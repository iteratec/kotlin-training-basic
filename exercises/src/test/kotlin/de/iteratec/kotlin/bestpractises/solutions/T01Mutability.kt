package de.iteratec.kotlin.bestpractises.solutions

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

data class User(val name: String, val email: String)

fun main() {
    val user = User("John Doe", "jon.doe@kotlin.course.com").copy(email = "john.doe@kotlin.training.com")

    val newUser = getUser() ?: User("default user", "")

    val trainings = listOf("kotlin-basics", "kotlin-advanced", "kotlin-best-practises")
    val trainings2 = buildList {
        addAll(listOf("kotlin-basics", "kotlin-advanced"))
        add("kotlin-best-practises")
    }

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