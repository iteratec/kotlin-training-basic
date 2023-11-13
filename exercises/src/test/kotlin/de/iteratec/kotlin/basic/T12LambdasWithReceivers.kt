package de.iteratec.kotlin.basic

import java.time.LocalDate
import java.time.format.DateTimeFormatter


/**
 * Things to discuss:
 * - lambdas vs lambdas with receiver
 * - scope functions with receiver
 */
fun main() {
    // Regular lambda with no receiver
    val announcementText1 = announcementNoReceiver {
        it.forToday()
        it.message = "Kotlin training is still in progress"
    }
    println("Announcement without receiver = $announcementText1")

    // Lambda with receiver. Inside the lambda, we pretend to be a member method of the receiver object.
    val announcementText2 = announcementWithReceiver {
        forToday()
        message = "Kotlin training is still in progress"
    }
    println("Announcement with receiver = $announcementText2")


    // Scope functions with receiver
    // 'with' function allows to switch context in the lambda as we were a member method of the receiver object
    val resultWithScopeFunction = with(StringBuilder()) {
        append("This")
        append(" is")
        append(" Sparta")
        toString()
    }
    println(resultWithScopeFunction)

    // 'apply' function does basically the same as 'with', but always returns the initial receiver object
    val resultApplyScopeFunction = StringBuilder().apply {
        append("This")
        append(" is")
        append(" Sparta")
        toString() // Will be ignored, 'apply' will return the initial StringBuilder
    }
    resultApplyScopeFunction.append("!!!")
    println(resultApplyScopeFunction)
}

fun announcementNoReceiver(configure: (Announcement) -> Unit): String {
    val announcement = Announcement()
    configure(announcement)
    return announcement.build()
}

fun announcementWithReceiver(configure: Announcement.() -> Unit): String {
    val announcement = Announcement()
    configure(announcement)

    // Alternative notation:
    // announcement.configure()

    return announcement.build()
}

class Announcement(private var date: String = "", var message: String = "") {

    fun forToday() {
        date = DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now())
    }

    fun forDate(date: String) {
        this.date = date
    }

    fun build(): String {
        return "ANNOUNCEMENT [$date] $message"
    }
}
