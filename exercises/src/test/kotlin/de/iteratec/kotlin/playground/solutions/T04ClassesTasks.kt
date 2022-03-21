package de.iteratec.kotlin.playground.solutions

import org.junit.Test

class Dog(val name: String, var weight: Int = 500) {
    fun gainWeight() {
        weight = weight * 2
    }
}

class T04ClassesTasks {

    /**
     * # Create a class
     * Create a class 'Dog' with read-only property 'name' (String) and mutable property 'weight' (Int) defined in the constructor.
     * Then create an instance of a Dog and print both properties.
     * Add a default value 500 for the property 'weight' in the constructor. Try it out.
     *
     * Optional: Add a method gainWeight to the class that doubles the weight of the dog. Try it out.
     */
    @Test
    fun yourFirstClass() {
        val dog1 = Dog("Heiko", 200)
        println(dog1.name)
        println(dog1.weight)
        val dog2 = Dog("Sabine")
        println(dog2.name)
        println(dog2.weight)
        dog2.gainWeight()
        println(dog2.weight)
    }
}
