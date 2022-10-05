package de.iteratec.kotlin.bestpractises

import kotlin.random.Random

data class Trainee(val name: String, val training: String, val age: Int)

/**
 * # Collections and lambdas
 *
 * - don't loop collections
 * - use higher-order functions of collections
 *
 */
fun getTrainees(): List<Trainee> {
    if(Random.nextBoolean()) return emptyList()

    val list =  mutableListOf<Trainee>()

    list.add(Trainee("Name0", if (Random.nextBoolean()) "kotlin" else "other", Random.nextInt(15, 95)))
    list.add(Trainee("Name1", if (Random.nextBoolean()) "kotlin" else "other", Random.nextInt(15, 95)))
    list.add(Trainee("Name2", if (Random.nextBoolean()) "kotlin" else "other", Random.nextInt(15, 95)))
    list.add(Trainee("Name3", if (Random.nextBoolean()) "kotlin" else "other", Random.nextInt(15, 95)))
    list.add(Trainee("Name4", if (Random.nextBoolean()) "kotlin" else "other", Random.nextInt(15, 95)))

    return list
}

fun main() {

    val trainees = getTrainees()
    println(trainees)

    val result = doSomething(trainees)
    println(result)
}

fun doSomething(trainees: List<Trainee>): Pair<String, Trainee?> {
    if (trainees.isEmpty()) {
        val error = "Trainees empty"
        println(error)
        throw IllegalArgumentException(error)
    }

    val kotlin = mutableListOf<Trainee>()
    val other = mutableListOf<Trainee>()
    var maxAger: Trainee? = null

    for (trainee in trainees) {
        if (maxAger == null || maxAger.age < trainee.age) {
            maxAger = trainee
        }
        if (trainee.age > 18) {
            if (trainee.training == "kotlin") {
                kotlin.add(trainee)
            } else {
                other.add(trainee)
            }
        }
    }

    var result: String
    if (kotlin.isEmpty()) {
        result = "only adult trainees for other"
    } else if (other.isEmpty()) {
        result = "only adult trainees for kotlin"
    } else {
        result = "adult trainees for both"
    }

    return Pair(result, maxAger)
}
