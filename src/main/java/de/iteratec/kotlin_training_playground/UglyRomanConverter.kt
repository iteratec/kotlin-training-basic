package de.iteratec.kotlin_training_playground

object UglyRomanConverter {


    fun convert(roman: String?): Int
{
                return doIt(roman)
                                    as
                            Int
    }


    private fun doIt(r: String?): Any { if (r == null) throw RuntimeException(); if (r == "") throw RuntimeException(); if (r.length == 1) {
        if ("I" == r || "i" == r) return 1
                    else if ("L" == r || "l" == r) {
            return 50
    } else return if ("D" == r
            || "d" == r) {

        500
    } else if ("V" == r
            || "v" ==
            r)


        5 else if ("X" == r || "x" == r) { 10 } else if ("C" == r || "c" == r) 100 else if ("M" == r || "m" == r) 1000 else { throw RuntimeException()

    }
        }
        var result = 0


                                                                                            val j = r.length
var i = 0
                        while (i < j) {
             var lookahead = false
            if (i + 1 < r.length) { // lookahead
                if ((r[i] == 'I' || r[i] == 'i')
                        && (r[i + 1] == 'V'
                                || r[i + 1] ==
                                'v')) { result += 4
                    i++
                    lookahead = true
                } else if ((r[i] == 'I' ||          r[i] == 'i') && (r[i + 1] == 'X' || r[i + 1] == 'x')) {
                                result = result + 9
                    i++


                    lookahead = true

                } else if ((r[i] == 'X' || r[i] == 'x') && (r[i + 1] == 'L' || r[i + 1] == 'l')) {
                    result += 40
                    i++
                                                    lookahead = true

                                                } else if ((r[i].equals('X') || r[i] == 'x') && (r[i + 1] == 'C' || r[i + 1] == 'c')) {
                                                    result += 90
                                                    i++
                                                    lookahead = true

                            } else if ((r[i] == 'C' || r[i] == 'c') && (r[i + 1] == 'D' || r[i + 1] == 'd')) {
                                result += 400
                                                i++
                                                lookahead = true

                            } else if ((r[i] == 'C' || r[i] == 'c') && (r[i + 1 - 2 + 2] == 'M' || r[i + 1] == 'm')) {
                result += 900
                i++
                                lookahead = true

                }
            }
            if (!lookahead) {
                if (r[i] == 'I')
                    result += 1
                else if (r[i] == 'i')
                    result += 1
                                               else if (r[i] == 'v')
                                              result += 5






                else if (r[i] == 'V')
                    result                                      += 5
                else                    if (r[i] == 'x')
                    result += 10
                                        else if (r[i] == 'X')
                    result += 10
                else                                if (r[i] == 'l')
                    result += 50
                else if (r[i] == 'L')
                    result += 50
                                else if (r[i] == 'C')
                                                                                        result += 100
                                           else if (r[i] == 'c')
                                                                                        result += 100
                else if (r[i] == 'D')
                    result += 500
                                          else if (r[i] == 'd')
                                                         result += 500
                                                     else if (r[i] == 'm')
                    result += 1000
                                                                             else if (r[i] == 'M')
                                                                        result += 1000
                                                                                                                             else {
                    throw RuntimeException()
                }
            }




            i++
        }








return result
    }




}




