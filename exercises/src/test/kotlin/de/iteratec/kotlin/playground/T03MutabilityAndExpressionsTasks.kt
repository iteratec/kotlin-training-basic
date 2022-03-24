package de.iteratec.kotlin.playground

import org.junit.Assert.assertEquals
import org.junit.Test

class MutabilityAndExpressionsTasks {

    /**
     * Task 1
     * Uncomment the line and fix the code, so it prints 'Lucy'.
     */
    @Test
    fun task1() {
        val catName = "Lisa"
        // catName = "Lucy"
        assertEquals("Lucy", catName)
    }

    /**
     * Task 2
     * Uncomment the line and fix the code, so it prints 'Lucy'
     */
    @Test
    fun task2() {
        var catName = 7
        // catName = "Lucy"
        assertEquals("Lucy", catName)
    }

    /**
     * Task 3
     * Use the fact that "try" is an expression to directly assign the variable riskyComputationResult without
     * declaring it first.
     */
    @Test
    fun task3() {
        var riskyComputationResult: String
        try {
            0 / 0
            riskyComputationResult = "succeeded"
        } catch (e: Exception) {
            riskyComputationResult = "failed"
        }

        assertEquals(riskyComputationResult, "failed")
    }
}
