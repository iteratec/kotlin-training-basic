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
        assertThat(IteratecEmployee("Heiko").getStatus(), equalTo("Heiko likes his/her job. But holiday is still better ;)"))
    }

    /**
     * ## Data classes
     * Data classes are classes for which equals, hashCode and toString are auto-implemented.
     * They also offer a copy-method that allows to generate new instances from existing ones.
     * Try to understand the following log-lines.
     * Can you imagine why data classes are not allowed to be subclassed?
     */
    @Test
    fun dataClass() {
        class NormalHorse(val name: String, val weight: Int = 500)
        data class DataHorse(val name: String, val weight: Int = 500)

        val normalHorse1 = NormalHorse("Albrecht Traber", 8)
        val normalHorse2 = NormalHorse("Albrecht Traber", 8)
        println("NormalHorse1 equals NormalHorse2 -> ${normalHorse1 == normalHorse2}")
        println("NormalHorse1 as string -> $normalHorse1")
        val normalHorse1AfterMarriage = NormalHorse("Albrecht Blondmähne", normalHorse1.weight)
        println("Married NormalHorse1 as string -> $normalHorse1AfterMarriage")

        println("------------------------------------")

        val dataHorse1 = DataHorse("Albrecht Traber", 8)
        val dataHorse2 = DataHorse("Albrecht Traber", 8)
        println("DataHorse1 equals DataHorse2 -> ${dataHorse1 == dataHorse2}")
        println("DataHorse1 as string -> $dataHorse1")
        val dataHorse1AfterMarriage = dataHorse1.copy(name = "Albrecht Blondmähne")
        println("Married DataHorse1 as string -> $dataHorse1AfterMarriage")
    }

    /**
     * ## Companion object
     * Implement a "static" builder function for the Horse class using a companion object such that the test code below
     * compiles and constructs the right horse
     */
    @Test
    fun companionObject() {
        class Horse(val name: String, val weight: Int = 500)

        // Implement a builder and uncomment these lines:
        //
        // val horse = Horse.builder().withName("Trabi").withWeight(10).build()
        // assertThat(horse.name, equalTo("Trabi"))
        // assertThat(horse.weight, equalTo(10))
    }
}
