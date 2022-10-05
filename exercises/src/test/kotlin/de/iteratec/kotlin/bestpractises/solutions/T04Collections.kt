package de.iteratec.kotlin.bestpractises.solutions

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

    return List(5) {
        Trainee("Name$it", if (Random.nextBoolean()) "kotlin" else "other", Random.nextInt(15, 95))
    }
}

fun main() {

    val result = doSomething(getTrainees())
    println(result)
}

fun doSomething(trainees: List<Trainee>): Pair<String, Trainee?> {
    require(trainees.isNotEmpty()) {
        "Trainees empty".also { println(it) }
    }

    return trainees
        .filter { it.age > 18 }
        .partition { it.training == "kotlin" }
        .let { (kotlin, other) ->
            when {
                kotlin.isEmpty() -> "only adult trainees for other"
                other.isEmpty() -> "only adult trainees for kotlin"
                else -> "adult trainees for both"
            }
        } to trainees.maxByOrNull { it.age }

}
