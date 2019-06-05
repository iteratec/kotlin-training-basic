package de.iteratec.kotlin_training_playground

import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters


@RunWith(value = Parameterized::class)
class RomanConverterTest(private val decimal: Int, private val roman: String?) {

    @Test
    fun convertTest() {
        if (this.decimal != -1) {
            assertEquals(this.decimal.toLong(), UglyRomanConverter.convert(this.roman).toLong())
        } else {
            try {
                UglyRomanConverter.convert(this.roman)
                fail("Error expected converting '" + this.roman + "'")
            } catch (e: NullPointerException) {
                fail()
            } catch (e: RuntimeException) {
                // everything ok
            }

        }
    }

    companion object {

        @Parameters(name = "#{index}:  {1} = {0}")
        @JvmStatic
        fun data(): Collection<Array<out Any?>> {
            val data = arrayOf(//
                arrayOf(1, "I"), //
                arrayOf(2, "II"), //
                arrayOf(3, "III"), //
                arrayOf(4, "IV"), //
                arrayOf(5, "V"), //
                arrayOf(6, "VI"), //
                arrayOf(7, "VII"), //
                arrayOf(8, "VIII"), //
                arrayOf(9, "IX"), //
                arrayOf(10, "X"), //
                arrayOf(11, "XI"), //
                arrayOf(12, "XII"), //
                arrayOf(13, "XIII"), //
                arrayOf(14, "XIV"), //
                arrayOf(15, "XV"), //
                arrayOf(16, "XVI"), //
                arrayOf(17, "XVII"), //
                arrayOf(18, "XVIII"), //
                arrayOf(19, "XIX"), //
                arrayOf(20, "XX"), //
                arrayOf(22, "XXII"), //
                arrayOf(26, "XXVI"), //
                arrayOf(29, "XXIX"), //
                arrayOf(30, "XXX"), //
                arrayOf(32, "XXXII"), //
                arrayOf(37, "XXXVII"), //
                arrayOf(45, "XLV"), //
                arrayOf(48, "XLVIII"), //
                arrayOf(49, "XLIX"), arrayOf(489, "CDLXXXIX"), //
                arrayOf(868, "DCCCLXVIII"), //
                arrayOf(1003, "MIII"), //
                arrayOf(2351, "MMCCCLI"), //
                arrayOf(3961, "MMMCMLXI"), arrayOf(5, "v"), //
                arrayOf(16, "xvi"), //
                arrayOf(17, "xvII"), //
                arrayOf(37, "XxXvii"), //
                arrayOf(2, "ii"), //
                arrayOf(48, "XlVIiI"), //
                arrayOf(-1, null), //
                arrayOf(-1, ""), //
                arrayOf(-1, "abc"), //
                arrayOf(-1, "i i"), //
                arrayOf(-1, "XI8") //
            )

            return data.asList()
        }
    }

}
