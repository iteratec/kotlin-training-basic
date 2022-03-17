package de.iteratec.kotlin.playground.solutions

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Test

val prefix = "Prefix"
val suffix = "suffix"

class T06StringsTasks {

    /**
     * Task stringInterpolation
     * Replace the left side of the assertion with a single Template String.
     */
    @Test
    fun stringInterpolation() {
        assertThat("${prefix}Infix${suffix.uppercase()}", equalTo(prefix + "Infix" + suffix.uppercase()))
    }

    /**
     * Task multilineString
     * Write the string below in more human-readable form using a multi-line string for the multilineString variable.
     */
    @Test
    fun multiLineString() {
        val header = "Famous last words:\n"
        val blankLine = "\n"
        val firstLine = "Anna: \"It worked on my machine!\"\n"
        val secondLine = "Sven: \"All tests are green. What could possibly go wrong?\""

        val originalString = header + blankLine + firstLine + secondLine

        val multilineString = """
            Famous last words:

            Anna: "It worked on my machine!"
            Sven: "All tests are green. What could possibly go wrong?"
        """.trimIndent()

        assertThat(multilineString, equalTo(originalString))
    }
}
