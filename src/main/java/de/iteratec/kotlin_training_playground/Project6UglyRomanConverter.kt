package de.iteratec.kotlin_training_playground

object UglyRomanConverter {

    fun convert(romanAnyCase: String): Int {
        val roman = romanAnyCase.toUpperCase()

        if (roman.isEmpty()) {
            throw RuntimeException()
        }

        if (roman.length == 1) {
            return valueOfRomanLetter(roman.first())
        }

        var result = 0

        var i = 0
        while (i < roman.length) {
            var lookahead = false
            if (i + 1 < roman.length) { // lookahead
                val value = valueOfTwoRomanLetters(roman.substring(i..i + 1))
                result += value
                if (value != 0) {
                    i++
                    lookahead = true
                }
            }

            if (!lookahead) {
                result += valueOfRomanLetter(roman[i])
            }

            i++
        }

        return result
    }

    private fun valueOfRomanLetter(letter: Char): Int {
        return when (letter.toUpperCase()) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> throw RuntimeException()
        }
    }

    private fun valueOfTwoRomanLetters(twoLetters: String): Int {
        require(twoLetters.length == 2)
        return when (twoLetters) {
            "IV" -> 4
            "IX" -> 9
            "XL" -> 40
            "XC" -> 90
            "CD" -> 400
            "CM" -> 900
            else -> 0
        }
    }

}
