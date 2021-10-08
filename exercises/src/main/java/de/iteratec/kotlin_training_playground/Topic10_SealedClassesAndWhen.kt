package de.iteratec.kotlin_training_playground

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

class RandomWorkshopParticipiantClass : WorkshopParticipant()
val RandomWorkshopParticipiant = RandomWorkshopParticipiantClass()

/**
 * Task 1
 * Does it make sense to instantiate 100 RandomWorkshopPatricipiant? Probably we are not able to answer that many questions.
 * Refactor the above variables (VornameNachname) with the object keyword to be singletons. (Declaring RandomWorkshopParticipiant to be an object does not sound right either ;) )
 */


/**
 * Task 2
 * Change the implementation of "getOs" to use a "when" expression.
 */

fun main() {
    println("ArturMarkiewicz uses ${ArturMarkiewicz.getOs()}")
    println("TomKriel uses ${TomKriel.getOs()}")
    println("MarcReczko uses ${MarcReczko.getOs()}")

    // Did you use a else-Branch for your implementation? What happens if you delete your else-branch? Now, we forgot to include another WorkshopParticipiant.
    // What different consequences does the inclusion of another WorkshopParticipiant have for "getOs" depending on whether we used a else-branch or not.
}
