package de.iteratec.kotlin.playground

import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class CollectionsAndLambdasTasks {

    data class FamilyMember(val knownParents: List<FamilyMember>, val age: Int, val name: String, val alive: Boolean)

    val Granny = FamilyMember(emptyList(), 83, "Elizabeth", true)
    val Margret = FamilyMember(listOf(Granny), 52, "Margret", true)
    val Winston = FamilyMember(emptyList(), 50, "Winston", false)
    val Neville = FamilyMember(emptyList(), 90, "Neville", false)
    val Boris = FamilyMember(listOf(Margret, Winston), 25, "Boris", true)
    val Charles = FamilyMember(listOf(Neville), 49, "Charles", true)
    val Teresa = FamilyMember(listOf(Margret, Charles), 19, "Teresa", true)

    /**
     * ## Instantiating collections
     * Initialize the property `familyMembers`, so it contains all family members listed above.
     * After that run the test `instantiatingCollections` to make sure, that the property is initialized correctly.
     */
    val familyMembers: Set<FamilyMember> = emptySet()

    @Test
    fun instantiatingCollections() {
        assertThat(familyMembers, hasItem(Granny))
        assertThat(familyMembers, hasItem(Margret))
        assertThat(familyMembers, hasItem(Winston))
        assertThat(familyMembers, hasItem(Neville))
        assertThat(familyMembers, hasItem(Boris))
        assertThat(familyMembers, hasItem(Charles))
        assertThat(familyMembers, hasItem(Teresa))
    }

    /**
     * ## Single map operation
     * Construct a list containing all names of the family members starting from "familyMembers" and using the map-function.
     */
    @Test
    fun singleMap() {
        val namesOfFamilyMembers: List<String> = emptyList() // Replace with familyMembers.map { ... }
        assertThat(familyMembers, hasItems("Elizabeth", "Margret", "Winston", "Neville", "Boris", "Charles", "Teresa"))
    }

    /**
     * ## Chained operations
     * Construct a list containing all ages of the alive family members sorted ascending.
     */
    @Test
    fun chainedOperations() {
        val agesOfFamilyMembers: List<Int> = emptyList() // Replace with familyMembers...
        assertThat(agesOfFamilyMembers, equalTo(listOf(19, 25, 49, 52, 83)))
    }

    /**
     * ## any operation
     * Write a function that checks if a familyMember is a parent of anyone in a list of family members.
     */
    @Test
    fun any() {
        fun isParentOfAnybody(allegedParent: FamilyMember, allegedChildren: Collection<FamilyMember>): Boolean {
            return true // Implement me
        }

        assertThat(isParentOfAnybody(Winston, listOf(Charles, Boris)), equalTo(true));
        assertThat(isParentOfAnybody(Winston, listOf(Neville, Margret)), equalTo(false));
    }

    /**
     * ## Extracting members
     * Extract the youngest family member out of your collection.
     */
    @Test
    fun extractingMembers() {
        val youngestFamilyMember = Granny // Replace this. Surely Granny is not the youngest one.
        assertThat(youngestFamilyMember.age, equalTo(19))
    }

    /**
     * ## fold operation
     * Calculate the combined age of all family members using fold (of course there are simpler methods to achieve this
     * goal in Kotlin indicated in the assertion in the exercise).
     */
    @Test
    fun fold() {
        val combinedAge = 0 // Replace with familyMembers.fold { ... }
        assertThat(combinedAge, equalTo(368))
    }

    /**
     * ## Lazy evaluation
     * Apart from using collections directly, you can also use Java streams or so-called sequences in Kotlin.
     * The main difference is that Streams and sequences evaluate lazily and apply all operations on one element
     * before proceeding with the next item when possible. This can have a positive performance impact in rare situations.
     *
     * Replace the mapping implemented via Java-streams with Kotlin collection operations or Kotlin
     * sequences (`collection.asSequence()`) and find out how the output changes.
     */
    @Test
    fun lazyEvaluation() {
        val firstFamilyMemberAfterSomeRiskyMappingComputation = familyMembers.stream()
            .map {
                println("In first mapping function with element ${it.name}")
                it
            }
            .map {
                println("In second mapping function with element ${it.name}")
                if (it.age > 50) it else throw RuntimeException("Some accident happened")
            }
            .findFirst().get()

        println(firstFamilyMemberAfterSomeRiskyMappingComputation.name)
    }
}
