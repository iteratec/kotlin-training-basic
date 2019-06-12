package de.iteratec.kotlin_training_playground

object UglyRomanConverter {

    fun convert(roman: String): Int {
        if (roman.isEmpty()) {
            throw RuntimeException()
        }

        if (roman.length == 1) {
            if ("I" == roman || "i" == roman) return 1
            else if ("L" == roman || "l" == roman) {
                return 50
            } else return if ("D" == roman
                || "d" == roman
            ) {

                500
            } else if ("V" == roman
                || "v" ==
                roman
            )


                5 else if ("X" == roman || "x" == roman) {
                10
            } else if ("C" == roman || "c" == roman) 100 else if ("M" == roman || "m" == roman) 1000 else {
                throw RuntimeException()

            }
        }
        var result = 0


        val j = roman.length
        var i = 0
        while (i < j) {
            var lookahead = false
            if (i + 1 < roman.length) { // lookahead
                if ((roman[i] == 'I' || roman[i] == 'i')
                    && (roman[i + 1] == 'V'
                            || roman[i + 1] ==
                            'v')
                ) {
                    result += 4
                    i++
                    lookahead = true

                } else if ((roman[i] == 'I' || roman[i] == 'i') && (roman[i + 1] == 'X' || roman[i + 1] == 'x')) {
                    result += 9
                    i++
                    lookahead = true

                } else if ((roman[i] == 'X' || roman[i] == 'x') && (roman[i + 1] == 'L' || roman[i + 1] == 'l')) {
                    result += 40
                    i++
                    lookahead = true

                } else if ((roman[i].equals('X') || roman[i] == 'x') && (roman[i + 1] == 'C' || roman[i + 1] == 'c')) {
                    result += 90
                    i++
                    lookahead = true

                } else if ((roman[i] == 'C' || roman[i] == 'c') && (roman[i + 1] == 'D' || roman[i + 1] == 'd')) {
                    result += 400
                    i++
                    lookahead = true

                } else if ((roman[i] == 'C' || roman[i] == 'c') && (roman[i + 1 - 2 + 2] == 'M' || roman[i + 1] == 'm')) {
                    result += 900
                    i++
                    lookahead = true

                }
            }

            if (!lookahead) {
                when (roman[i]) {
                    'I' -> result += 1
                    'i' -> result += 1
                    'v' -> result += 5
                    'V' -> result += 5
                    'x' -> result += 10
                    'X' -> result += 10
                    'l' -> result += 50
                    'L' -> result += 50
                    'C' -> result += 100
                    'c' -> result += 100
                    'D' -> result += 500
                    'd' -> result += 500
                    'm' -> result += 1000
                    'M' -> result += 1000
                    else -> throw RuntimeException()
                }
            }

            i++
        }

        return result
    }

}
