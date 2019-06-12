package de.iteratec.kotlin_training_playground

data class Dog(
    val name: String = "dog",
    val age: Int = 1
)

fun main() {
    val dog = Dog(name = "Kessi")
    println("dog = $dog")
}
