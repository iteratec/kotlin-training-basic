package de.iteratec.kotlin.playground.solutions

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Test

class SealedClassesAndWhenTasks {

    enum class GermanParty {
        CDU, SPD, DIE_PARTEI
    }

    sealed class GermanChancellor {
        fun getParty(): GermanParty {
            return when (this) {
                is PhilippScheidemann -> GermanParty.SPD
                is Angie -> GermanParty.CDU
                is MartinSonneborn -> GermanParty.DIE_PARTEI
            }
        }
    }

    object Angie : GermanChancellor()
    object PhilippScheidemann: GermanChancellor()
    object MartinSonneborn: GermanChancellor()

    /**
     * ## When
     * Change the implementation of "getParty" to use a "when" expression.
     */
    @Test
    fun taskWhen() {
        assertThat(PhilippScheidemann.getParty(), equalTo(GermanParty.SPD))
        assertThat(Angie.getParty(), equalTo(GermanParty.CDU))
        assertThat(MartinSonneborn.getParty(), equalTo(GermanParty.DIE_PARTEI))
        // Did you use an else-Branch for your implementation? What happens if you delete your else-branch?
        // -> The compiler should complain because there are cases for which no return value of type GermanParty can be constructed.

        // Now, imagine YOU become German chancellor tomorrow and add an object representing you. Great :).
        // What different consequences does this addition of a new member of GermanChancellor have for "getParty"
        // depending on whether we used an else-branch or not?
        // -> Without the else-branch this is safer. Otherwise we might forget to update the function and run in the else-branch which could be an error.
    }
}
