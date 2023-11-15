package de.iteratec.kotlin.basic

/**
# Collections & lambdas
Requirements:
- Functions
- Mutability and expressions

Things to discuss:
- Instantiating collections
- Mutable & immutable collections
- Collection transformations & lambdas
- Sequences
 */
fun main() {
    // Kotlin collections can be instantiated via factory methods of the form "<CollectionType>Of(...)"
    val alphabet: List<Char> = listOf('a', 'b', 'c')
    val words: MutableList<String> = mutableListOf("Rentner", "Lehrer", "Student")

    // Collections are immutable per default. Use mutable factory methods to instantiate mutable collections.
    words.add("IT-Berater")
    // the following does not compile
    // alphabet.add('ü')

    // Transformations can be directly used on the collection. They usually accept a lambda as a parameter. All the following is basically equivalent.
    val a = words.map(String::uppercase) // method reference
    val b = words.map({ word ->
        println("In lambda body")
        word.uppercase()
    }) // lambda: Last line evaluated gets returned automatically
    val c = words.map({ word -> word.uppercase() })
    val d = words.map() { word -> word.uppercase() }  // Lambda as the last argument of a function call can be taken out of the argument list
    val e = words.map { word -> word.uppercase() }  // Empty argument list can be omitted
    val f = words.map { it.uppercase() } // If lambda has only one argument, you can refer to it with 'it'
    val g = words.asSequence()
        .filter { it.length > 4 }
        .map { it.uppercase() }.toList()
    println("Using a lambda or method reference with map $a")

    // Kotlin offers a lot of convenient methods from the Filter-Map-Reduce-idiom. Most methods return new lists.

    // filter: Applies a boolean function to all elements and keeps only those elements that have been evaluated to true
    println("Filter: ${words.filter { it.length > 7 }}")

    // map: Applies a transformation function to all elements and replaces them with the result
    println("Map: ${words.map { it + "in" }}")

    // sortBy: Applies a function with a Comparable return type to all elements and sorts them in ascending order with respect to this Comparable
    println("Sort: ${words.sortedBy { it.length }}")

    // any/all: Tests whether at least one/all elements fulfill a predicate
    println("At least one: ${words.any { it.length > 3 }}")
    println("All: ${words.all { it.length > 3 }}")

    // fold: Accumulates all elements of the collection into a single value
    // Starts with an initial value and then iteratively transforms this value by applying a function to it and the next element of the collection.
    println("Fold: ${words.fold("initial") { alreadyAccumulatedStuff, nextElement -> alreadyAccumulatedStuff + nextElement }}")

    // There are also functions to extract members of collections
    // first: Extracts the first element of the collection
    println("First: ${words.first()}")

    // maxByOrNull: Searches the maximum of all elements of the collection by applying the lambda and using the natural
    // ordering on the return type (which has to implement Comparable).
    println("maxByOrNull: ${words.maxByOrNull { it.length }}")
}


