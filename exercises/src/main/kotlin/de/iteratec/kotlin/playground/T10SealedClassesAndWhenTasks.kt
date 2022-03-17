package de.iteratec.kotlin.playground

import org.junit.Test

class SealedClassesAndWhenTasks {

    enum class GermanParty {
        CDU, SPD, DIE_PARTEI
    }

    sealed class GermanChancellor {
        fun getParty(): GermanParty {
            return if (this is FriedrichEbert) {
                GermanParty.SPD
            } else if (this is Angie) {
                GermanParty.CDU
            } else {
                GermanParty.DIE_PARTEI
            }
        }
    }

    object Angie : GermanChancellor()
    object FriedrichEbert: GermanChancellor()
    object MartinSonneborn: GermanChancellor()


    /**
     * ## When
     * Change the implementation of "getParty" to use a "when" expression.
     */
    @Test
    fun taskWhen() {
        println("Friedrich Ebert is member of ${FriedrichEbert.getParty()}")
        println("Dr. Angela Merkel is member of ${Angie.getParty()}")
        println("Martin Sonneborn is member of ${MartinSonneborn.getParty()}")
        // Did you use an else-Branch for your implementation? What happens if you delete your else-branch?
        // Now, imagine YOU become German chancellor tomorrow. Great :).
        // What different consequences does this addition of a new member of GermanChancellor have for "getParty" depending on whether we used a else-branch or not.
    }
}
