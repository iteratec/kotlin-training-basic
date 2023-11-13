package de.iteratec.kotlin.basic.solutions

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert
import org.junit.Test

class ExtensionFunctionsTasks {

    fun String?.replaceUmlaute(): String = this
        ?.replace("ä", "ae")
        ?.replace("ö", "oe")
        ?.replace("ü", "ue")
        ?.replace("ß", "ss")
        ?: ""

    /**
     * ## Extension function
     * Rewrite replaceUmlauteInString to be an extension function of String such that the assertion is met.
     */
    @Test
    fun extensionFunction() {
        val myString = "Tränenüberströmter Strauß"
        assertThat(myString.replaceUmlaute(), equalTo("Traenenueberstroemter Strauss"))
    }

    /**
     * ## Nullables & extension functions
     * Rewrite replaceUmlauteInString to be able to being called on null (returning an empty string in this case).
     */
    @Test
    fun extensionFunctionAndNullSafety() {
        val nullInsteadOfAString = null
        assertThat(nullInsteadOfAString.replaceUmlaute(), equalTo(""))
    }

    /**
     * ## let function and null-safety
     * Replace the implementation of wrapIntoList with a suitable one-liner using "let".
     */
    @Test
    fun letAndNullSafety() {
        fun wrapIntoList(input: Int?): List<Int> = input?.let { listOf(input) } ?: emptyList<Int>()

        Assert.assertTrue(wrapIntoList(null).isEmpty())
        assertThat(wrapIntoList(2), equalTo(listOf(2)))
    }
}
