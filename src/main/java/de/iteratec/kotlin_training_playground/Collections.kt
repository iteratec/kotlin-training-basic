package de.iteratec.kotlin_training_playground

// immutable list by default, mutable lists
// Kotlin stdlib: sort, take, filter, etc.
// eager vs sequences
// functional syntax: forEach
// mapping: map, groupBy

/*
 * Kotlin Koans:
 * ==============
 *  - Introduction
 *      - Hello, world! :)
 *
 *  - Collections
 */

data class Member(val firstName: String, val lastName: String)

fun main() {
    val abc = listOf('a', 'b', 'c')

    val trainingMembers = listOf(
        Member("Pablo", "Roman"),
        Member("Rachael", "Piper"),
        Member("Jonas", "Terrell"),
        Member("Mary", "Travis"),
        Member("Christian", "Findlay")
    )

    for (member in trainingMembers) {
        println("Welcome to the training, ${member.firstName} ${member.lastName}!")
    }
}


