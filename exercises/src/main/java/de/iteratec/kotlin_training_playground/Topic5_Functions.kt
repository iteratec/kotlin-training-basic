package de.iteratec.kotlin_training_playground

fun addAll(a: Int, b: Int, c: Int, d: Int): Int {
    return a + b + c + d
}

fun main() {
    shortFunctionSyntaxTask()
    callingFunctionsWithNamedArgumentsTask()
    defaultValues()
}

/**
 * Task shortFunctionSyntax
 * The function body of "addAll" is rather trivial because it is basically a one-liner and the return type can easily be auto-inferred. Write "add" in the short one-liner syntax.
 */
fun shortFunctionSyntaxTask() {
    println("#### Task shortFunctionSyntaxTask: Should print 6")

    println(addAll(0, 1, 2, 3));
}


/**
 * Task callingFunctionsWithNamedArguments
 * "addAll" has many arguments. Theoretically one could mix up the order when calling the function. Replace the invocation above with an invocation with named arguments.
 * You can also play around and mix positional and named arguments to see what happens.
 */
fun callingFunctionsWithNamedArgumentsTask() {
    println("#### Task shortFunctionSyntaxTask: Should print 6")

    println(addAll(0, 1, 2, 3))
}


/**
 * Task defaultValues
 * It would also make sense to call "addAll" with 2 or 3 arguments. Add default values for c and d such that the code below compiles and prints the desired results
 */
fun defaultValues() {
    println("#### Task shortFunctionSyntaxTask: Should print 1 and 3")

    // println(addAll(0, 1))
    // println(addAll(0, 1, 2))
}


