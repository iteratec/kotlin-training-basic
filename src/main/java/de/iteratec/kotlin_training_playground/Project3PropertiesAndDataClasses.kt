package de.iteratec.kotlin_training_playground

class Dog {

    var name: String = "dog"
    var age: Int = 1

}

fun main() {
    val dog = Dog()
    dog.name = "Kessi"
    dog.age = 5

    println("dog = $dog")
}
