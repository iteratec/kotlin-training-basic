package de.iteratec.kotlin.basic

import org.junit.Test

class ExtensionFunctionsTasks {

    fun replaceUmlaute(input: String): String = input
        .replace("ä", "ae")
        .replace("ö", "oe")
        .replace("ü", "ue")
        .replace("ß", "ss")

    /**
     * ## Extension function
     * Rewrite replaceUmlauteInString to be an extension function of String such that the assertion is met.
     */
    @Test
    fun extensionFunction() {
        val myString = "Tränenüberströmter Strauß"
        // assertThat(myString.replaceUmlaute(), equalTo("Traenenueberstroemter Strauss"))
    }

    /**
     * ## Nullables & extension functions
     * Rewrite replaceUmlauteInString to be able to being called on null (returning an empty string in this case).
     */
    @Test
    fun extensionFunctionAndNullSafety() {
        val nullInsteadOfAString = null
        // assertThat(nullInsteadOfAString.replaceUmlaute(), equalTo(""))
    }
}
