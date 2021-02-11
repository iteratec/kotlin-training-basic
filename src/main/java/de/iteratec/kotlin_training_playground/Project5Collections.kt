package de.iteratec.kotlin_training_playground

/*
 * Kotlin Koans:
 * ==============
 *  - Introduction
 *      - Hello, world! :)
 *
 *  - Collections
 *      - Introduction
 *      - Sort
 *      - Filter map
 *      - All Any and other predicates
 *      - Max min
 *      - Sum
 *      - FlatMap
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

// immutable list by default, show mutable lists

// show the full power of the Kotlin stdlib: sort, take, filter, etc.

// eager by default

// sequences (aka streams)

// more functional syntax: forEach

// mapping: map, groupBy
