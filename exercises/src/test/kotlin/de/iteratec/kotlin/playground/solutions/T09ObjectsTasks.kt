package de.iteratec.kotlin.playground.solutions

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Test
import kotlin.math.absoluteValue

class ObjectsTasks {

    /**
     * ## Objects
     * Imagine our business logic needs some custom logic where we want to sort floats by absolute value.
     * As we need this logic in many places, define an object AbsoluteValueComparator of type Comparator<Float>.
     * Treat null values as you please.
     */
    @Test
    fun objects() {
        val listOfFloats = listOf(3f, 2.0f, -1.0f, -4.0f, 0f)
        assertThat(listOfFloats.sortedWith(AbsoluteValueComparator), equalTo(listOf(0f, -1.0f, 2.0f, 3.0f, -4.0f)))
    }

    /**
     * ## Companion object
     * Implement a "static" builder function for the Horse class using a companion object such that the test code below
     * compiles and constructs the right horse
     * Hint: The builder should return an instance of a new class HorseBuilder.
     */
    @Test
    fun companionObject() {
        val horse = Horse.builder().withName("Trabi").withWeight(10).build()
        assertThat(horse.name, equalTo("Trabi"))
        assertThat(horse.weight, equalTo(10))
    }
}

class Horse(val name: String, val weight: Int = 500) {
    companion object {
        fun builder() = HorseBuilder()
    }
}

class HorseBuilder(var name: String = "", var weight: Int = 500) {
    fun withName(name: String): HorseBuilder {
        this.name = name
        return this
    }

    fun withWeight(weight: Int): HorseBuilder {
        this.weight = weight
        return this
    }

    fun build() = Horse(name, weight)
}

object AbsoluteValueComparator: Comparator<Float> {
    override fun compare(o1: Float?, o2: Float?): Int {
        return if (o1 == null || o2 == null) {
            0
        } else {
            o1.absoluteValue.compareTo(o2.absoluteValue)
        }
    }
}