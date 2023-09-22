package de.iteratec.kotlin.playground

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertTrue
import org.junit.Test

class ClassesAdvancedTasks {

    /**
     * ## Inheritance
     * Make IteratecEmployee inherit Employee and override the method.
     * Use the open keyword to enable inheritance & method overriding.
     */
    @Test
    fun inheritance() {
        class Employee(val name: String) {
            fun getStatus() = "$name hates his/her job and longs for holiday"
        }

        class IteratecEmployee(val name: String) {
            fun getStatus() = "$name likes his/her job. But holiday is still better ;)"
        }

        // assertTrue(IteratecEmployee("Lisa") is Employee)
        assertThat(
            IteratecEmployee("Lisa").getStatus(),
            equalTo("Lisa likes his/her job. But holiday is still better ;)")
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
     * ## Data classes copy()
     * The data class below represents a generic role-play character with different stats.
     * Adjust the code to use the copy() method to make out rogue a bit more charismatic by increasing
     * the 'char' attribute.
     */
    @Test
    fun dataClassCopyMethod() {
        data class RpgCharacter(val str: Int, val dex: Int, val int: Int, val char: Int)
        val rogue = RpgCharacter(str = 5, dex = 12, int = 8, char = 3)
        val charismaticRogue = RpgCharacter(str = rogue.str, dex = rogue.dex, int = rogue.int, char = 20)

        assertThat(charismaticRogue.str, equalTo(rogue.str))
        assertThat(charismaticRogue.dex, equalTo(rogue.dex))
        assertThat(charismaticRogue.int, equalTo(rogue.int))
        assertThat(charismaticRogue.char, equalTo(20))
    }

    /**
     * Think about the following questions:
     *
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
