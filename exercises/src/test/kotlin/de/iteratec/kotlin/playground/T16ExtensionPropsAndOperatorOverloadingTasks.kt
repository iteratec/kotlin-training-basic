package de.iteratec.kotlin.playground

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Test
import kotlin.math.roundToInt

class T16ExtensionPropsAndOperatorOverloadingTasks {
    /**
     * taskExtensionProperties
     * Add an extension property kelvin to temperature in order to read/write the temperature in Kelvin.
     */
    @Test
    fun taskExtensionProperties() {
        val temperature = Temperature(10f)
/*    temperature.kelvin = 300f
        assertThat(temperature.kelvin, equalTo(300f)) */
        assertThat(temperature.celsius.roundToInt(), equalTo(27))
    }

    /**
     * taskExtensionProperties
     * Add overator overloading to Temperature such that -temperature alternates the sign of the degree in celsius (the name of the function has to be unaryMinus).
     */
    @Test
    fun taskOperatorOverloading() {
        val temperature = Temperature(10f)
        // assertThat(-temperature, equalTo(Temperature(-10f)))
    }
}

data class Temperature(
    var celsius: Float
)