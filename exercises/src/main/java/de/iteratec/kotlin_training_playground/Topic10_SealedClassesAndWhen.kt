package de.iteratec.kotlin_training_playground

import java.time.LocalDate

sealed class ApplicationException(message: String = "", cause: Throwable? = null) : RuntimeException(message, cause)

class DatabaseInVacationException(message: String = "", cause: Throwable? = null) : ApplicationException(message, cause)

class ExpectedFuckupException(message: String = "", cause: Throwable? = null) : ApplicationException(message, cause)

class EverythingWorkedTooWellToBeTrueException(message: String = "", cause: Throwable? = null) :
    ApplicationException(message, cause)

class ErrorHandler() {
    fun handleError(exception: ApplicationException) {
        val loggingMessage = when (exception) {
            is DatabaseInVacationException,
            is ExpectedFuckupException -> exception.message
            is EverythingWorkedTooWellToBeTrueException -> "It works. Very suspicious."
        }

        when (LocalDate.now().dayOfWeek.name) {
            "MONDAY",
            "TUESDAY",
            "WEDNESDAY",
            "THURSDAY",
            "FRIDAY" -> println(loggingMessage)
            "SATURDAY",
            "SUNDAY" -> Unit // Do not bother colleagues during their weekend
            else -> println("Are there more than 7 weekdays?")
        }
    }
}

fun main() {
    val errorHandler = ErrorHandler()
    errorHandler.handleError(ExpectedFuckupException("Can somebody please fix this?"))
    errorHandler.handleError(EverythingWorkedTooWellToBeTrueException())
    taskWhen()
}


enum class Os {
    WINDOWS, MAC, LINUX
}

sealed class WorkshopParticipant() {
    fun getOs(): Os {
        return if (this is ArturMarkiewiczClass) {
            Os.WINDOWS
        } else if (this is MarcReczkoClass) {
            Os.MAC
        } else {
            Os.LINUX
        }
    }
}

class TomKrielClass : WorkshopParticipant()

val TomKriel = TomKrielClass()

class ArturMarkiewiczClass : WorkshopParticipant()

val ArturMarkiewicz = ArturMarkiewiczClass()

class MarcReczkoClass : WorkshopParticipant()

val MarcReczko = MarcReczkoClass()

class YourFirstnameYourLastnameClass : WorkshopParticipant()

val You = YourFirstnameYourLastnameClass()

/**
 * Task Object
 * Does it make sense to instantiate 100 YourFirstnameYourLastnameClass? Probably we are not able to answer that many questions.
 * Refactor the above variables (VornameNachnameClass) with the object keyword to be singletons. (Declaring You to be an object does not sound right either ;) )
 */


/**
 * Task When
 * Change the implementation of "getOs" to use a "when" expression.
 */

fun taskWhen() {
    println("ArturMarkiewicz uses ${ArturMarkiewicz.getOs()}")
    println("TomKriel uses ${TomKriel.getOs()}")
    println("MarcReczko uses ${MarcReczko.getOs()}")
    println("You use ${You.getOs()}")

    // Did you use a else-Branch for your implementation? What happens if you delete your else-branch? Now, we forgot to include another WorkshopParticipiant.
    // What different consequences does the inclusion of another WorkshopParticipiant have for "getOs" depending on whether we used a else-branch or not.
}
