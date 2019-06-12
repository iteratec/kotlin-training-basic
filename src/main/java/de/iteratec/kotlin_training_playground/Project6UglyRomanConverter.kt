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
                if (roman[i] == 'I' && roman[i + 1] == 'V') {
                    result += 4
                    i++
                    lookahead = true

                } else if (roman[i] == 'I' && roman[i + 1] == 'X') {
                    result += 9
                    i++
                    lookahead = true

                } else if (roman[i] == 'X' && roman[i + 1] == 'L') {
                    result += 40
                    i++
                    lookahead = true

                } else if (roman[i] == 'X' && roman[i + 1] == 'C') {
                    result += 90
                    i++
                    lookahead = true

                } else if (roman[i] == 'C' && roman[i + 1] == 'D') {
                    result += 400
                    i++
                    lookahead = true

                } else if (roman[i] == 'C' && roman[i + 1] == 'M') {
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
