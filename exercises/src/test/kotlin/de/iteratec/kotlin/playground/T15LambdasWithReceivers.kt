package de.iteratec.kotlin.playground

fun header(name: String) = """
Dear ${name},
    
"""

val footer = """
            
Yours sincerely, Harald Answer-Machine
Certified bullshitting expert"""

fun writeLetterNoReceiver(name: String, messageCustomizer: (StringBuilder) -> Unit): String {
    val letterBuilder = StringBuilder()
    letterBuilder.append(header(name))
    messageCustomizer(letterBuilder)
    letterBuilder.append(footer)

    return letterBuilder.toString()
}

// We have already seen that we can define so-called extension functions outside a class that can only be called on a receiver and can access it by "this".
// We remind you that extension functions are only syntactic sugar and are replaced with ordinary functions by the compiler. They allow us to make utility functions more beautiful for instance.

// As an extension of this concept, we can also define lambdas with receivers.
fun writeLetterReceiver(name: String, messageCustomizer: StringBuilder.() -> Unit): String {
    val letterBuilder = StringBuilder()
    letterBuilder.append(header(name))
    letterBuilder.messageCustomizer()
    letterBuilder.append(footer)

    return letterBuilder.toString()
}

// Lambdas with receivers are almost exclusively used as argument of other function (typically last argument).
// Since the lambda with receiver needs a proper receiver, it is the responsability of the other function to provide some and call the lambda on it.
fun main() {
    val letterNoReceiver = writeLetterNoReceiver("0815-Kunde") {
        it.append("It depends.")
    }

    val letterReceiver = writeLetterReceiver("0815-Kunde") {
        append("It depends.")
    }

    println(letterNoReceiver)
    println("----------------------------")
    println(letterReceiver)
}

