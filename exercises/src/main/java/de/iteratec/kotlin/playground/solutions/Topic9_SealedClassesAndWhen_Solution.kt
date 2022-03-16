package de.iteratec.kotlin.playground.solutions

import java.lang.RuntimeException
import java.time.LocalDate

// Sealed classes can only be subclassed in the same package. This can be helpful because we do not have to worry that
// somebody adds a new sub-class possibly breaking functionality we built that relies on the fact that there are no further implementations.
sealed class ApplicationStatus

class RanIntoException(val exception: Exception) : ApplicationStatus()

// Sometimes, we are sure that we only ever need one singleton instance of a class. For this purpose, we can define an "object",
// which is a class that gets instantiated immediately automatically. The unique singleton instance of this class can simply be referenced by the class name itself.
object Healthy : ApplicationStatus()
object TooLazyToDoWork : ApplicationStatus()

fun handleApplicationStatus(status: ApplicationStatus) {
    // when is Kotlins clever branching mechanism. It is like a more ressourceful switch-statement.
    // "when" is an expression and returns the element behind the first matching branch

    val loggingMessage: String = when (status) {
        is Healthy -> "Everything is healthy. Very suspicious."
        // Kotlin smart-casts status to the right sub-class
        is RanIntoException -> "Ran into exception: ${status.exception}"
        is TooLazyToDoWork -> "Application is grumpy. We should treat it better."
    }
    // Since we assign the result of "when" to a variable, Kotlin would not compile, if we had forgotten a sub-class.

    when (LocalDate.now().dayOfWeek.name) {
        "MONDAY",
        "TUESDAY",
        "WEDNESDAY",
        "THURSDAY",
        "FRIDAY" -> println(loggingMessage)
        "SATURDAY",
        "SUNDAY" -> Unit // Do not bother anybody during their weekend
        else -> println("Are there more than 7 weekdays?")
    }
    // The else-case above is not needed here for compilation. Since we do not assign the result of "when" to a variable,
    // there would not be any problem when no case matches.
}

fun main() {
    handleApplicationStatus(Healthy)
    handleApplicationStatus(RanIntoException(RuntimeException("Database is in vacation and not available")))
    handleApplicationStatus(TooLazyToDoWork)

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
 * Replace YourFirstnameYourLastname with your real name.
 * Does it make sense to instantiate 100 YourFirstnameYourLastnameClass? Probably we are not able to answer that many questions.
 * Refactor the above variables (VornameNachnameClass) with the object keyword to be singletons. (Declaring you to be an object does not sound right either ;) )
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
