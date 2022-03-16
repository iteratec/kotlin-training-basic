package de.iteratec.kotlin.playground.solutions

class BoilerplateResultClass(
    val hasBeenSuccessful: Boolean,
    val typeOfSave: TypeOfSave
)

enum class TypeOfSave {
    NEW, UPDATE
}

fun createOrUpdate(): BoilerplateResultClass {
    return BoilerplateResultClass(true, TypeOfSave.NEW)
}

fun createOrUpdateWithoutBoilerplateResultClass(): Pair<Boolean, TypeOfSave> {
    return Pair(true, TypeOfSave.NEW)
}

data class ExampleDataClass(
    val first: String,
    val second: Int
)

fun main() {
    val example = ExampleDataClass("first", 2)
    // Many existing classes in Kotlin offer positional destructuring. With this technique you can assign several variables at once.
    // Data classes support destructuring. The order of the attributes in the constructor is important.
    val (first: String, second: Int) = example
    // Destructuring for lists extracts the first elements. You can skip the assignment of an attribute to a variable by using the placeholder "_"
    val myList = listOf(1, 2, 3, 4, 5)
    val (position1, _, position3) = myList

    // Try yourself
    multipleReturnValuesFromAFunction()
    implementingDestructuring()
    whenNotToUseDestructuring()
}

/**
 * Task multipleReturnValuesFromAFunction
 * The Pair<A,B> class is very useful in Kotlin. An instance of Pair<A,B> consists of an instance of A that can be accessed via the first()-method and an instance of B that can be accessed via the second()-method.
 * Pair<A,B> supports destructuring declarations. Pair<A,B> is for instance used to represent key-value-pairs of maps.
 * Sometimes, we want a function to return multiple values without introducing a lot of boilerplate by creating an extra class representing the return type.
 * Create a new version of the function "createOrUpdate" named "createOrUpdateWithoutBoilerplateResultClass" such that it returns a "Pair<A,B>" and the code below compiles.
 */
fun multipleReturnValuesFromAFunction() {
    println("#### Task multipleReturnValuesFromAFunction")

    val result: BoilerplateResultClass = createOrUpdate()
    println(result.hasBeenSuccessful)
    println(result.typeOfSave)

    val (success, typeOfSave) = createOrUpdateWithoutBoilerplateResultClass()
    println(success)
    println(typeOfSave)
}

/**
 * Task implementingDestructuring
 * Strings do not offer destructuring. Implement destructuring for strings in the sense that the first component of the destructuring declaration is the first letter of the string.
 * Desturing functions are declared as operator overloading functions. Those have to start with the "operator" keyword and the name of the function determines which operator will be defined.
 * For destructuring the function componentN defines the N-th component (where N is a positive number). Since we do not own the String class, we have to define our Operator overload as an extension function.
 * We have prepared the right signature. It is up to you to provide the correct implementation.
 */
fun implementingDestructuring() {
    println("#### Task implementingDestructuring")
    val (first) = "hallo"
    println("First letter of \"hallo\" is $first")
    val (shouldBeNull) = ""
    println("First letter of \"\" is $shouldBeNull")
}

operator fun String.component1(): Char? {
    return this.firstOrNull()
}



/**
 * Task whenNotToUseDestructuring
 * Unfortunately, destructuring works on positionally and not by naming. Think of a case where the usage of destructuring might incorporate a risk.
 */
fun whenNotToUseDestructuring() {
    println("#### Task implementingDestructuring")
    println("No code need to be written here")
    /*
    Destructuring should only be used when the order of the components is canonically clear, the components have non-intersecting types or the attributes of the class are certain to remain unchanged in the future.
    Consider the class CakeRecipe.
    An uncautious developer could add another attribute amountOfCocoaInGramm an put it in the third position shifting amountOfFlourInGramm into fourth position.
    This will affect all existing destructuring declarations because component3 has changed. We might not notice this source of potential errors because the return type of component3 stayed the same.
    Of course, the change of our developer would also cause constructor invocations of CakeRecipe to change. The difference is that the compiler will warn us in the case with an error.
     */
}

data class CakeRecipe(
    val amountOfButterInGramm: Int,
    val amountOfSugarInGramm: Int,
    val amountOfFlourInGramm: Int
)
