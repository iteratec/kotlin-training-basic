package de.iteratec.kotlin_training_playground

fun main() {
    val a = "This is a non-null string with implicit type"
    val b: String = "This is a non-null string with explicit type"

    // this is not possible :-)
//    val c : String = null

    // this can be null
    val d: String? = null

    // all these variables are final, so this won't work:
//    a = ""
//    b = ""
//    d = ""

    // this is a mutable variable:
    var e = ""
    e = "this can be mutated"


    println(
        """
        a = $a
        b = $b
        d = $d
        e = $e
        """.trimIndent()
    )
}

// val/var

// nullable types
