package de.iteratec.kotlin.playground

import org.junit.Test

class ObjectsTasks {

    /**
     * ## Objects
     * Imagine our business logic needs some custom logic where we want to sort floats by absolute value.
     * As we need this logic in many places, define an object AbsoluteValueComparator of type Comparator<Float>.
     * Treat null values as you please.
     */
    @Test
    fun objects() {
/*        val listOfFloats = listOf(3f, 2.0f, -1.0f, -4.0f, 0f)
        assertThat(listOfFloats.sortedWith(AbsoluteValueComparator), equalTo(listOf(0f, -1.0f, 2.0f, 3.0f, -4.0f)))*/
    }

    /**
     * ## Companion object
     * Implement a "static" builder function for the Horse class using a companion object such that the test code below
     * compiles and constructs the right horse
     */
    @Test
    fun companionObject() {
        // val horse = Horse.builder().withName("Trabi").withWeight(10).build()
        // assertThat(horse.name, equalTo("Trabi"))
        // assertThat(horse.weight, equalTo(10))
    }
}

class Horse(val name: String, val weight: Int = 500)
