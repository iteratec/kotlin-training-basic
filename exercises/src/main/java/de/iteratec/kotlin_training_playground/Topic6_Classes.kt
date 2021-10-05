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

    yourFirstClass()
    dataClass()
    inheritance()
}

// ---- Try it yourself!

/**
 * Task yourFirstClass
 * Create a class 'Horse' with properties 'name' (String) and 'weight' (Int) defined in the constructor.
 * Add a default value 500 for the property 'weight'.
 * Then create an instance of a Horse and print both properties.
 */
private fun yourFirstClass() {
    println("#### Task YourFirstClass")
    // You can define the class right here inside the function!
}

/**
 * Task dataClass
 * Uncomment the code. Copy your class 'Horse' and transform it into a data class HorseAsDataClass and check how the output changes.
 *
 * Then use the copy function to create another instance of HorseAsDataClass with a different name and same weight as its prototype.
 */
private fun dataClass() {
    println("#### Task dataClass")
/*   val horse1 = Horse("Albrecht", 8)
    val horse2 = Horse("Albrecht", 8)
    println(horse1 == horse2)
    println(horse1)

    val horse3 = HorseAsDataClass("Albrecht", 8)
    val horse4 = HorseAsDataClass("Albrecht", 8)
    println(horse3 == horse3)
    println(horse4)*/
}

/**
 * Task inheritance
 * Make IteratecEmployee inherit Employee and override the method such that it prints "Heiko likes his/her job. But holiday is still better ;)".
 */
private fun inheritance() {
    println("Task inheritance: Should print: Heiko likes his/her job. But holiday is still better ;)")
    class Employee(val name: String) {
        fun getStatus() = "$name hates his/her job and longs for holiday"
    }

    class IteratecEmployee(val name: String) {
        fun getStatus() = "$name likes his/her job. But holiday is still better ;)"
    }

/*        val employee: Employee = IteratecEmployee("Heiko")
        println(employee.getStatus())*/
}

/**
 * Task companion object
 */
private fun companionObject() {
    // Implement a "static" builder function for the Horse class using a companion object such that the test code below compiles and constructs the right horse
    // val horse = Horse.builder().withName("Trabi").withWeight(10).build()
    // println(horse.name)
    // println(horse.weight)
}