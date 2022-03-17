package de.iteratec.kotlin.playground

import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Test

class ClassesAdvancedTasks {

    /**
     * ## Inheritance
     * Make IteratecEmployee inherit Employee and override the method such that it prints "Heiko likes his/her job. But holiday is still better ;)".
     * The open keyword means that things can be subclassed/overidden. By default classes/methods/properties cannot be overidden.
     */
    @Test
    fun inheritance() {
        open class Employee(val name: String) {
            open fun getStatus() = "$name hates his/her job and longs for holiday"
        }

        class IteratecEmployee(val name: String) {
            fun getStatus() = "$name likes his/her job. But holiday is still better ;)"
        }

        assertThat(IteratecEmployee("Heiko"), instanceOf(Employee::class.java))
        assertThat(
            IteratecEmployee("Heiko").getStatus(),
            equalTo("Heiko likes his/her job. But holiday is still better ;)")
        )
    }

    /**
     * ## Data classes
     * Run the test and cry because it is not green.
     * Change the classes to be "data classes" and run the test again. It should be green. Be happy and puzzled at the same time.
     * Try to understand why the test has become green
     */
    @Test
    fun dataClass() {
        class Coordinates(
            val x: Int,
            val y: Int,
        )

        val heightMap: HashMap<Coordinates, Int> = HashMap()
        val origin = Coordinates(0,0)
        heightMap.put(Coordinates(0,0), 5)
        assertThat(heightMap.get(origin), equalTo(5))
    }

    /**
     * Think about the following questions
     * One could be tempted to use data classes all the time. Think of situations when it is better not to use a data class.
     * Can you imagine why data classes are not allowed to be subclassed?
     */
    @Test
    fun questionsOnDataClasses() {}

    /**
     * ## Custom getters and setters
     * Customize getters and setters such that the tests become green.
     */
    @Test
    fun customGettersAndSetters() {
        class ValidatedNaturalNumberHolder {
            // Ignore all attempts to set naturalNumber to a negative number
            var naturalNumber: Int = 0
        }

        class SuperSecretSelfDestructingCodeHolder {
            // With each read, message should be reset back to an empty string
            var message: String = ""
        }

        val naturalNumberHolder = ValidatedNaturalNumberHolder()
        naturalNumberHolder.naturalNumber = 10
        naturalNumberHolder.naturalNumber = -20
        assertThat(naturalNumberHolder.naturalNumber, equalTo(10))

        val secretHolder = SuperSecretSelfDestructingCodeHolder()
        secretHolder.message = "I have plundered the candy stack of my colleague"
        assertThat(secretHolder.message, equalTo("I have plundered the candy stack of my colleague"))
        assertThat(secretHolder.message, equalTo(""))
    }
}