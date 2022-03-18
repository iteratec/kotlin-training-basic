package de.iteratec.kotlin.playground

// We have already seen that we can define so-called extension functions outside of a class that can only be called on a receiver and can access it by "this".
// We remind you that extension functions are only syntactic sugar and are replaced with ordinary functions by the compiler. They allow us to make utility functions more beautiful for instance.

// As an extension of this concept, we can also define lambdas with receivers.

fun writeLetter(name: String, messageCustomizer: StringBuilder.() -> Unit): String {
    val letterBuilder = StringBuilder()
    letterBuilder.append(
        """
            Dear ${name},
            
            we are thankful for your message and have worked day and night to provide the best possible answer in the shortest possible amount of time. 
            After numerous discussions and considerations we are sure the answer to your question is:
            
        """.trimIndent()
    )
    letterBuilder.messageCustomizer()
    letterBuilder.append(
        """
            
           We hope we have satisfied all your concerns and desires. We are happy to hear from your again,
            
           Yours sincerely, Harald Answer-Machine
           Certified bullshitting expert
        """.trimIndent()
    )
    return letterBuilder.toString()
}

// Lambdas with receivers are almost exclusively used as argument of other function (typically last argument).
// Since the lambda with receiver needs a proper receiver, it is the responsability of the other function to provide some and call the lambda on it.

fun main() {
    val letter = writeLetter("0815-Kunde") {
        append("It depends.")
    }
    println(letter)
    // Notice that the compiler knows what "this" is and which functions we are allowed to call.
    // The general type of a lambda with receiver is "Receiver.(Argument1, Argument2, ...) -> ReturnType"
}

