package de.iteratec.kotlin.playground

import java.lang.RuntimeException
import java.time.LocalDate

/**
 # Sealed classes, when & object
 Requirements:
 - mutability and expressions
 - classes

 Things to discuss:
 - sealed classes
 - when & exhaustiveness
 */

// Sealed classes can only be subclassed only in the same package (since Kotlin 1.5).
sealed class ApplicationStatus
object Healthy : ApplicationStatus()
object TooLazyToDoWork : ApplicationStatus()
class RanIntoException(val exception: Exception) : ApplicationStatus()

fun handleApplicationStatus(status: ApplicationStatus) {
    // When is a smarter version of switch-case from Java
    val loggingMessage: String = when (status) {
        is Healthy -> "Everything is healthy. Very suspicious."
        // Kotlin smart-casts status to the right sub-class
        is RanIntoException -> "Ran into exception: ${status.exception}"
        is TooLazyToDoWork -> "Application is grumpy. We should treat it better."
    }

    when (LocalDate.now().dayOfWeek.name) {
        "MONDAY",
        "TUESDAY",
        "WEDNESDAY",
        "THURSDAY",
        "FRIDAY" -> println(loggingMessage)
        "SATURDAY",
        "SUNDAY" -> Unit
        else -> println("Are there more than 7 weekdays?")
    }
}

fun main() {
    handleApplicationStatus(Healthy)
    handleApplicationStatus(RanIntoException(exception = RuntimeException("Database is in vacation and not available")))
    handleApplicationStatus(TooLazyToDoWork)
}
