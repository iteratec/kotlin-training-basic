package de.iteratec.kotlin_training_playground

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class Project10ParserTest {

    private val file = File("project10parseme.txt")

    @Test
    fun `parse 1 simple customer`() {
        val content = "Kunde:\t\t\tMustermann, Max, männlich"
        assertEquals(
            listOf(
                SimpleCustomer(
                    firstName = "Max",
                    lastName = "Mustermann",
                    gender = Gender.Male
                )
            ), parseSimpleCustomers(content)
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

        assertEquals(emptyList<SimpleCustomer>(), parseSimpleCustomers(content))
    }

    @Test
    fun `parse 2 simple customers`() {
        val content = """
            Kunde:			Mustermann, Max, männlich
            Kunde:			Musterfrau, Erika, weiblich
        """.trimIndent()
        assertEquals(
            listOf(
                SimpleCustomer(
                    firstName = "Max",
                    lastName = "Mustermann",
                    gender = Gender.Male
                ),
                SimpleCustomer(
                    firstName = "Erika",
                    lastName = "Musterfrau",
                    gender = Gender.Female
                )
            ), parseSimpleCustomers(content)
        )
    }

    @Test
    fun `read whole file into chunks`() {
        val content = file.readText()
        val chunks = readIntoCustomerChunks(content)
        assertEquals(3, chunks.size)
        chunks.forEach { chunk ->
            assertEquals(5, chunk.size)
            assertTrue(chunk.first().startsWith("Kunde:"))
        }
    }

    @Test
    fun `read all customers`() {
        val content = file.readText()
        val actual = parseCustomers(content)
        assertEquals(3, actual.size)
        assertEquals(
            Customer(
                "Max",
                "Mustermann",
                Gender.Male,
                31,
                "1234 5678 9012 3456 Visa",
                "32387,37 EUR",
                "Autos, Eisenbahnen, Tennis, Kochen,"
            ), actual.first()
        )
    }

}
