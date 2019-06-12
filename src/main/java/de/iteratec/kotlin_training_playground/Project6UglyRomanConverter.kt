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
                val letters = roman.substring(i..i + 1)
                if (letters == "IV") {
                    result += 4
                    i++
                    lookahead = true

                } else if (letters == "IX") {
                    result += 9
                    i++
                    lookahead = true

                } else if (letters == "XL") {
                    result += 40
                    i++
                    lookahead = true

                } else if (letters == "XC") {
                    result += 90
                    i++
                    lookahead = true

                } else if (letters == "CD") {
                    result += 400
                    i++
                    lookahead = true

                } else if (letters == "CM") {
                    result += 900
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

}
