package de.iteratec.kotlin.playground

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
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
        assertThat(FriedrichEbert.getParty(), equalTo(GermanParty.SPD))
        assertThat(Angie.getParty(), equalTo(GermanParty.CDU))
        assertThat(MartinSonneborn.getParty(), equalTo(GermanParty.DIE_PARTEI))
        // Did you use an else-Branch for your implementation? What happens if you delete your else-branch?
        // Now, imagine YOU become German chancellor tomorrow and add an object representing you. Great :).
        // What different consequences does this addition of a new member of GermanChancellor have for "getParty"
        // depending on whether we used an else-branch or not.
    }
}
