package de.iteratec.kotlin.playground.solutions

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertEquals
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
     * Create a variable count in the companion object of ClassWithInstanceCount which records the count of generated instances.
     */
    @Test
    fun companionObject() {
        assertEquals(0, ClassWithInstanceCount.count)
        val instance1 = ClassWithInstanceCount()
        assertEquals(1, ClassWithInstanceCount.count)
        val instance2 = ClassWithInstanceCount()
        assertEquals(2, ClassWithInstanceCount.count)
    }
}

class ClassWithInstanceCount() {
    init {
        count = count + 1
    }
    companion object {
        var count: Int = 0
    }
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