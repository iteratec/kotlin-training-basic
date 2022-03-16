package de.iteratec.kotlin.playground

import org.junit.Test

class ExtensionFunctionsTasks {

    fun replaceUmlaute(input: String): String = input
        .replace("ä", "ae")
        .replace("ö", "oe")
        .replace("ü", "ue")
        .replace("ß", "ss")

    /**
     * ## Extension function
     * Rewrite replaceUmlauteInString to be an extension function of String such that the code compiles and
     * prints "Traenenueberstroemter Strauss".
     */
    @Test
    fun extensionFunction() {
        val myString = "Tränenüberströmter Strauß"
        // Refactor replaceUmlaute to an extension function and uncomment this line to test:
        // assertThat(myString.replaceUmlaute(), equalTo("Traenenueberstroemter Strauss"))
    }

    /**
     * ## Nullables & extension functions
     * Rewrite replaceUmlauteInString to be able to being called on null (returning an empty string in this case).
     */
    @Test
    fun extensionFunctionAndNullSafety() {
        val nullInsteadOfAString = null
        // Modify replaceUmlaute to handle nullability and uncomment this line to test:
        // assertThat(nullInsteadOfAString.replaceUmlaute(), equalTo(""))
    }
}
