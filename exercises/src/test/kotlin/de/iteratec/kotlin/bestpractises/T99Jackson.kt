package de.iteratec.kotlin.bestpractises

enum class Gender{ FEMALE, MALE, DIVERSE }

data class Person(
    val name: String,
    val gender: Gender,
    val age: Int,
    val eyeColor: String? = null
)

/**
 * 1. Serialize a Person object into a JSON string. Print the string and compare to the object.
 * 2. Deserialize a JSON string into a Person object (tip: copy the JSON string from #1). Compare the given Person object and the deserialized object.
 * 3. The given eyeColor is always serialized as null-Value. We want to avoid this.
 * 4. Our data class uses the property name 'age', but in JSON we want to have 'maturity'. (Don't rename 'age' in data class ;-) )
 * 5. Add into JSON string a new property unknown to data class. What happens and how can we avoid this?
 *
 */

fun main() {
    val person = Person("Max", Gender.MALE, 33)

    println(person)
}