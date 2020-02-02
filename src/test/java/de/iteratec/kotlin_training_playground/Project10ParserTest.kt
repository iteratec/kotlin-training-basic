package de.iteratec.kotlin_training_playground

import org.junit.Assert.assertEquals
import org.junit.Test

class Project10ParserTest {

    @Test
    fun `parse 1 simple customer`() {
        val content = "Kunde:\t\t\tMustermann, Max, männlich"
        assertEquals(
            listOf(
                Customer(
                    firstName = "Max",
                    lastName = "Mustermann",
                    gender = Gender.Male
                )
            ), parseCustomers(content)
        )
    }

    @Test
    fun `all other lines are ignored`() {
        val content = """
            Alter:			31 Jahre
            Kreditkarte:	1234 5678 9012 3456 Visa
            Kontostand:		32387,37 EUR
            Interessen:		Autos, Eisenbahnen, Tennis, Kochen,
            
        """.trimIndent()

        assertEquals(emptyList<Customer>(), parseCustomers(content))
    }

    @Test
    fun `parse 2 simple customers`() {
        val content = """
            Kunde:			Mustermann, Max, männlich
            Kunde:			Musterfrau, Erika, weiblich
        """.trimIndent()
        assertEquals(
            listOf(
                Customer(
                    firstName = "Max",
                    lastName = "Mustermann",
                    gender = Gender.Male
                ),
                Customer(
                    firstName = "Erika",
                    lastName = "Musterfrau",
                    gender = Gender.Female
                )
            ), parseCustomers(content)
        )
    }

}
