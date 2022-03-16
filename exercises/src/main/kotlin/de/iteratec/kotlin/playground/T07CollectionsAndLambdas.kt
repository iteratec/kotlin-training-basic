package de.iteratec.kotlin.playground

/**
# Collections & lambdas
 Requirements:
 - Functions
 - Mutability and expressions

 Things to discuss:
 - Instantiating collections
 - Mutable & immutable collections
 - Collection transformations & lambdas
 */
fun main() {
    // Kotlin has its own collection hierarchy that is very similar to Java and uses the analogous Java collections under the hood.
    // Normally you instantiate collections via factory methods of the form "<CollectionType>Of(...)"
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

    // There are also functions to extract members of collections
    // first: Extracts the first element of the collection
    println("First: ${words.first()}")
    // maxByOrNull: Searches the maximum of all elements of the collection by applying the lambda and using the natural ordering on the return type (which has to implement Comparable).
    println("maxByOrNull: ${words.maxByOrNull { it.length }}")
}


