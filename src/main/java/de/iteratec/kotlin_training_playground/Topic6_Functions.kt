package de.iteratec.kotlin_training_playground

// default parameters
// extension functions
// types & short-hand syntax for expressions
// lambdas

fun printSomething(message: String) {
    println(message)
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun main() {
    printSomething("something")
    val sumOf2And4 = sum(2, 4)
    printSomething("sum of 2 and 4 is $sumOf2And4")

//    val uuid = toUUID("ff820e1b-312f-4e48-94b0-967f3808dc8c")
//    println(uuid)

    task1()
    task2()
    task3()
}


// ---- Try it yourself!


/**
 * Task 1
 * Uncomment the lines and implement the feed() function, so that the output is:
 * 'cat was fed with fish'
 * 'cat was fed with meat'
 */
private fun task1() {
    println("#### Task 1")

    //fun feed() { TODO() }
    //feed(animal = "cat", food = "fish")
    //feed(animal = "cat")
}

/**
 * Task 2
 * Implement a lambda function, that calculates the BMI of a cat (weight / (height*height)).
 * Then call the lambda and print the BMI of Lucy. Check the inferred type of the 'bmi' variable (ctrl+q).
 */
private fun task2() {
    println("#### Task 2")

    class Cat(val name: String, val weight: Double, val height: Double)
    // TODO val bmi = { }
    val lucy = Cat(name = "Lucy", weight = 8.0, height = 0.3)
    // TODO println()
}

/**
 * Task 3
 * Uncomment the lines and implement an extension function isCatSound() on String,
 * that returns true when the string is "meow" or "pur" and false otherwise.
 */
private fun task3() {
    println("#### Task 3")

    //println("meow".isCatSound())
    //println("pur".isCatSound())
    //println("woof".isCatSound())
}
