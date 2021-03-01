package de.iteratec.kotlin_training_playground

// constructor props & default values
// data classes - default methods, copy, destructing declarations
// Java interop

class Dog {
    var name: String = "dog"
    var age: Int = 1
}

fun main() {
    val dog = Dog()
    dog.name = "Kessi"
    dog.age = 5

    println("dog = $dog")

    task1()
    task2()
    task3()
}


// ---- Try it yourself!


/**
 * Task 1
 * Create a class 'Horse' with props 'name' (String) and 'weight' (Int) defined in the constructor.
 * Add a default value 500 for the prop 'weight'.
 * Then create an instance of a Horse and print both properties.
 */
private fun task1() {
    println("#### Task 1")

    // You can define the class right here inside the function!
}

/**
 * Task 2
 * Turn 'Horse' into a data class and check how the output changes.
 */
private fun task2() {
    println("#### Task 2")

    class Horse(val name: String, val age: Int)

    val horseAlbrecht = Horse("Albrecht", 8)
    val horseAlbrecht2 = Horse("Albrecht", 8)
    println(horseAlbrecht == horseAlbrecht2)
    println(horseAlbrecht)
}

/**
 * Task 3
 * Use the copy function to create another instance of Lucy with a sound 'Pur pur'.
 * All other properties should remain unchanged.
 */
private fun task3() {
    println("#### Task 3")

    data class Cat(val name: String, val age: Int, val sound: String, val isHungry: Boolean)
    val lucy = Cat(name = "Lucy", age = 4, sound = "Meow meow", isHungry = false)
    println(lucy)
}