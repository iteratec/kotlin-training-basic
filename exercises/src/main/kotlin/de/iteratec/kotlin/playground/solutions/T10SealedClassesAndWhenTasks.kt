package de.iteratec.kotlin.playground.solutions

import org.junit.Test

class SealedClassesAndWhenTasks {

    enum class GermanParty {
        CDU, SPD, DIE_PARTEI
    }

    sealed class GermanChancellor {
        fun getParty(): GermanParty {
            return when (this) {
                is FriedrichEbert -> GermanParty.SPD
                is Angie -> GermanParty.CDU
                is MartinSonneborn -> GermanParty.DIE_PARTEI
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
        // -> The compiler should complain because there are cases for which no return value of type GermanParty can be constructed.

        // Now, imagine YOU become German chancellor tomorrow. Great :).
        // What different consequences does this addition of a new member of GermanChancellor have for "getParty" depending on whether we used a else-branch or not.
        // -> Without the else-branch this is safer. Otherwise we might forget to update the function and run in the else-branch which could be an error.
    }
}
