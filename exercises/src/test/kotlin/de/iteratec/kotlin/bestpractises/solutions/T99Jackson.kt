package de.iteratec.kotlin.bestpractises.solutions

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

enum class Gender{ FEMALE, MALE, DIVERSE }

@JsonInclude(JsonInclude.Include.NON_EMPTY) // 3.
data class Person(
    val name: String,
    val gender: Gender,
    @JsonProperty("maturity")
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
 *
 * maybe this link helps: https://github.com/FasterXML/jackson-module-kotlin
 */

fun main() {
    val person = Person("Max", Gender.MALE, 33)

    println(person)

    // 1.
    val mapper = jacksonObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false) //5. ignore unknown properties in JSON
    val personJson = mapper.writeValueAsString(person) ?: throw IllegalStateException("could not serialize person $person")
    println(personJson)

    // 2.
    val jsonString = """{
        "name":"Max",
        "gender":"MALE",
        "maturity":33, 
        "eyeColor":null,
        "hairColor": "brown"
    }""".trimMargin() // 4. age -> maturity must be changed or we are missing a mandatory property during deserialization

    val jsonPerson = mapper.readValue<Person>(jsonString)
    println(jsonPerson)
}