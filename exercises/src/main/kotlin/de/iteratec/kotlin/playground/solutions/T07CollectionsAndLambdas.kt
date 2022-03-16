package de.iteratec.kotlin.playground.solutions

fun main() {
    // Kotlin has its own collection hierarchy that is very similar to Java and uses the analogeours Java collections under the hood.
    // Normally you instantiate collections via factory methods of the form "CollectionInterfaceNameOf(...)"
    val alphabet: List<Char> = listOf('a', 'b', 'c')
    val words: MutableList<String> = mutableListOf("Rentner", "Lehrer", "Student")

    // Collections normally offer no methods to alter the members after the initialization. Only their subclasses prefixed
    // with "Mutable" offer this functionality.
    words.add("IT-Berater")
    // the following does not compile
    // alphabet.add('ü')

    // The Filter-Map-Reduce-Pattern can be used on collections directly. Java streams are rarely needed in Kotlin.
    // filter, map, reduce, ... are methods already equipped to the Collection interface.
    // As an argument they accept a method reference or lambda
    val a = words.map(String::uppercase) // method reference
    val b = words.map({ word ->
        println("In lambda body")
        word.uppercase()
    }) // lambda: Last line evaluated gets returned automatically
    val c = words.map() { word -> word.uppercase() } // Convention: a lambda as the last argument of a function call can be taken out of the argument list
    val d = words.map { word -> word.uppercase() }
    val e = words.map { it.uppercase() } // Convention: For a lambda with only one argument, you can omit the argument and reference it with it

    println(a)
    println(b)
    println(c)
    println(d)
    println(e)

    // Kotlin offers a lot of convenient methods from the Filter-Map-Reduce-idiom. Most methods return new lists.

    // filter: Applies a boolean function to all elements and keeps only those elements that have been evaluated to true
    println("Filter: ${words.filter { it.length > 7 }}")

    // map: Applies a transformation function to all elements and replaces them with the result
    println("Map: ${words.map { it + "in" }}")

    // sortBy: Applies a function with a Comparable return type to all elements and sorts them in ascending order with respect to this Comparable
    println("Sort: ${words.sortedBy { it.length }}")

    // any/all: Tests whether at least one/all elements fulfill a predicate
    println("Any: ${words.any { it.length > 3 }}")
    println("Some: ${words.all { it.length > 3 }}")

    // fold: Accumulates all elements of the collection into a single value
    // Starts with an initial value and then iteratively transforms this value by applying a function to it and the next element of the collection.
    println("Fold: ${words.fold("initial") { alreadyAccumulatedStuff, nextElement -> alreadyAccumulatedStuff + nextElement }}")


    // Try it yourself
    instantiatingCollections()
    oneFMROperation()
    chainingFMROperations()
    any()
    extractingMembers()
    fold()
    bonus_eager()
}

class FamilyMember(val knownParents: List<FamilyMember>, val age: Int, val name: String, val alive: Boolean)

val Granny = FamilyMember(emptyList(), 83, "Elizabeth", true)
val Margret = FamilyMember(listOf(Granny), 52, "Margret", true)
val Winston = FamilyMember(emptyList(), 50, "Winston", false)
val Neville = FamilyMember(emptyList(), 90, "Neville", false)
val Boris = FamilyMember(listOf(Margret, Winston), 25, "Boris", true)
val Charles = FamilyMember(listOf(Neville), 49, "Charles", true)
val Teresa = FamilyMember(listOf(Margret, Charles), 19, "Teresa", true)

/**
 * Task instantiatingCollections
 * Define and assign the whole set of family members in the order above to the variable familyMembers in one line.
 */
val familyMembers: Set<FamilyMember> = emptySet()
fun instantiatingCollections() {
    println(familyMembers.contains(Granny))
    println(familyMembers.contains(Margret))
    println(familyMembers.contains(Winston))
    println(familyMembers.contains(Neville))
    println(familyMembers.contains(Boris))
    println(familyMembers.contains(Charles))
    println(familyMembers.contains(Teresa))
}

/**
 * Task oneFMROperation
 * Construct a list containing all names of the family members starting from "familyMembers" and using the map-function
 */
fun oneFMROperation() {
    val namesOfFamilyMembers: List<String> = familyMembers.map { it.name }
    println(namesOfFamilyMembers == listOf("Elizabeth", "Margret", "Winston", "Neville", "Boris", "Charles", "Teresa"))
}

/**
 * Task chainingFMROperations
 * Construct a list containing all ages of the alive family members sorted ascendingly
 */
fun chainingFMROperations() {
    val agesOfFamilyMembers: List<Int> = familyMembers.filter { it.alive }.sortedBy { it.age }.map { it.age }
    println(agesOfFamilyMembers == listOf(19, 25, 49, 52, 83))
}

/**
 * Task any
 * Write a function that checks if a familyMember is a parent of anyone in a list of family members
 */

fun any() {
    fun isParentOfAnybody(allegedParent: FamilyMember, allegedChildren: Collection<FamilyMember>): Boolean {
        return allegedChildren.any { it.knownParents.contains(allegedParent) }
    }

    println(isParentOfAnybody(Winston, listOf(Charles, Boris)))
    println(!isParentOfAnybody(Winston, listOf(Neville, Margret)))
}

/**
 * Task extractingMembers
 * Extract the youngest family member out of your collection
 */

fun extractingMembers() {
    val youngestFamilyMember = familyMembers.minByOrNull { it.age } // or maxByOrNul { -it.age }
    println(youngestFamilyMember)
}

/**
 * Task fold
 * Calculate the combined age of all family members using fold (of course there are simpler methods to achieve this goal
 * in Kotlin indicated in the assertion in the exercise)
 */

fun fold() {
    val combinedAge = familyMembers.fold(0) { walkingSum, summand -> walkingSum + summand.age }
    println(combinedAge == familyMembers.sumOf { it.age })
}

/**
 * Task bonus_eager
 * Apart from using collections directly, you can also use Java streams or so-called sequences in Kotlin.
 * The main difference is that Streams and sequences evaluate lazily and apply all operations on one element
 * before proceeding with the next item when possible. This caan have a positive performance impact in rare situations.
 * Try out what happens and in what order when trying out a Java Stream, Kotlin list, Kotlin sequence as the receiver of
 * the first map function.
 */

fun bonus_eager() {
    // Sequences
    val firstFamilyMemberAfterSomeRiskyMappingComputation = familyMembers.asSequence()
        .map {
            println("In first mapping function with element ${it.name}")
            it
        }
        .map {
            println("In second mapping function with element ${it.name}")
            if (it.age > 50) it else throw RuntimeException("Some accident happened")
        }
        .first()

    // List: Throws exception
/*    val firstFamilyMemberAfterSomeRiskyMappingComputation = familyMembers
        .map {
            println("In first mapping function with element ${it.name}")
            it
        }
        .map {
            println("In second mapping function with element ${it.name}")
            if (it.age > 50) it else throw RuntimeException("Some accident happened")
        } */

    // Java streams
/*    val firstFamilyMemberAfterSomeRiskyMappingComputation = familyMembers.stream()
        .map {
            println("In first mapping function with element ${it.name}")
            it
        }
        .map {
            println("In second mapping function with element ${it.name}")
            if (it.age > 50) it else throw RuntimeException("Some accident happened")
        }
        .findFirst().get() */

    println(firstFamilyMemberAfterSomeRiskyMappingComputation.name)
}



