package de.iteratec.kotlin_training_playground

// val/var
// type inference
// expressions

fun main() {
    val cat = "Katy Purry"
    println(cat)

    task1()
    task2()
    task3()
    task4()
}


// ---- Try it yourself!


/**
 * Task 1
 * Uncomment the line and fix the code, so it prints 'Lucy'
 */
private fun task1() {
    println("#### Task 1")

    val catName = "Lisa"
    // catName = "Lucy"
    println(catName)
}

/**
 * Task 2
 * Uncomment the line and fix the code, so it prints 'Lucy'
 */
private fun task2() {
    println("#### Task 2")

    var catName = 7
    // catName = "Lucy"
    println(catName)
}

/**
 * Task 3
 * Uncomment the line and fix the code, so it prints 'Lucy'
 */
private fun task3() {
    println("#### Task 3")

    var catName = null
    // catName = "Lucy"
    println(catName)
}

/**
 * Task 4
 * Use the fact that "if" and "try" are expressions to directly assign the variables conditionAsString and riskyComputationResult without declaring them first
 */
private fun task4() {
    println("#### Task 4")

    val condition = true

    val conditionAsString: String
    if (condition) {
        conditionAsString = "true"
    } else {
        conditionAsString = "false"
    }

    var riskyComputationResult: String
    try {
        0 / 0
        riskyComputationResult = "succeeded"
    } catch (e: Exception) {
        riskyComputationResult = "failed"
    }

    println("ConditionAsString(true) returns " + conditionAsString)
    println("riskyComputation " + riskyComputationResult)
}
