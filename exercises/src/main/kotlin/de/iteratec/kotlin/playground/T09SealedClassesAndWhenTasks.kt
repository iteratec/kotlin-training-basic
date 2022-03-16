package de.iteratec.kotlin.playground

import org.junit.Test

class SealedClassesAndWhenTasks {

    enum class Os {
        WINDOWS, MAC, LINUX
    }

    sealed class WorkshopParticipant {
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
    @Test
    fun taskObject() {
        TODO()
    }

    /**
     * ## When
     * Change the implementation of "getOs" to use a "when" expression.
     */
    @Test
    fun taskWhen() {
        println("ArturMarkiewicz uses ${ArturMarkiewicz.getOs()}")
        println("TomKriel uses ${TomKriel.getOs()}")
        println("MarcReczko uses ${MarcReczko.getOs()}")
        println("You use ${You.getOs()}")
        // Did you use a else-Branch for your implementation? What happens if you delete your else-branch? Now, we forgot to include another WorkshopParticipiant.
        // What different consequences does the inclusion of another WorkshopParticipiant have for "getOs" depending on whether we used a else-branch or not.
    }
}
