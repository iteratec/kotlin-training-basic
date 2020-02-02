package de.iteratec.kotlin_training_playground

import de.iteratec.kotlin_training_playground.Interest.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File
import java.math.BigDecimal
import java.util.*

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
            Kreditkarte:	1234 5678 9012 3456, Visa
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
                "1234 5678 9012 3456, Visa",
                "32387,37 EUR",
                "Autos, Eisenbahnen, Tennis, Kochen,"
            ), actual.first()
        )
    }

    @Test
    fun `read 1 customer with all types`() {
        val content = """
            Kunde:			Mustermann, Max, männlich
            Alter:			31 Jahre
            Kreditkarte:	1234 5678 9012 3456, Visa
            Kontostand:		32387,37 EUR
            Interessen:		Autos, Eisenbahnen, Tennis, Kochen,
        """.trimIndent()
        assertEquals(
            listOf(
                TypeSafeCustomer(
                    "Max",
                    "Mustermann",
                    Gender.Male,
                    31,
                    CreditCard("1234 5678 9012 3456", "Visa"),
                    Balance(BigDecimal("32387.37"), Currency.getInstance("EUR")),
                    setOf(Autos, Eisenbahnen, Tennis, Kochen)
                )
            ), parseTypeSafeCustomers(content)
        )
    }

    @Test
    fun `read all customers type-safe`() {
        val content = file.readText()
        assertEquals(
            listOf(
                TypeSafeCustomer(
                    "Max",
                    "Mustermann",
                    Gender.Male,
                    31,
                    CreditCard("1234 5678 9012 3456", "Visa"),
                    Balance(BigDecimal("32387.37"), Currency.getInstance("EUR")),
                    setOf(Autos, Eisenbahnen, Tennis, Kochen)
                ),
                TypeSafeCustomer(
                    "Erika",
                    "Musterfrau",
                    Gender.Female,
                    33,
                    CreditCard("0101 3373 2093 1934", "Mastercard"),
                    Balance(BigDecimal("54230.05"), Currency.getInstance("EUR")),
                    setOf(Programmieren, Autos, Aktien)
                ),
                TypeSafeCustomer(
                    "Dagobert",
                    "Duck",
                    Gender.Male,
                    73,
                    CreditCard("1337 1337 1337 1337", "Entencard"),
                    Balance(
                        BigDecimal("13224567778000000.16"), Currency.getInstance("USD")
                    ),
                    setOf(Geld, Reichtum)
                )
            ), parseTypeSafeCustomers(content)
        )
    }

}
