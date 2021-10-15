package de.iteratec.kotlin_training_playground.solutions

/* Things to explain as instructor:
- Inspect Kotlin bytecode and decompiled Java class (Shift, Shift -> Show Kotlin Bytecode -> Decompile)
- Comparison with main-function in Java
- Explain function syntax and Unit in Kotlin
- Java to Kotlin Converter in IntelliJ (Right click on File -> Convert Java file to Kotlin file)
- Invocation with positional or named arguments
- One-liner syntax
- Default values
 */

// The main-function is the entry point of an application
fun main(args: Array<String>) {
    println("Hello Kotlin!")
    println("Called with args" + args)

    // Functions can be called with positional or named arguments. The following invocations are equivalent.
    simpleExampleFunction("argument1", "argument2")
    simpleExampleFunction(argument2 = "argument2", argument1 = "argument1")
    simpleExampleFunction(argument1 = "argument1", "argument2")

    // Functions that consist of only one expression can be defined in a more concise syntax
    simpleExampleFunctionInOneLinerSyntax("argument1", "argument2")

    // The following invocations yield the same result
    simpleExampleFunctionWithDefaultValues(argument1 = "argument1")
    simpleExampleFunctionWithDefaultValues(argument1 = "argument1", argument2 = "")

    // Try it yourself
    functionSyntaxTask()
    callingFunctionsWithNamedArgumentsTask()
    defaultValues()
}

private fun simpleExampleFunction(argument1: String, argument2: String): String {
    return argument1 + argument2
}

private fun simpleExampleFunctionInOneLinerSyntax(argument1: String, argument2: String) = argument1 + argument2

private fun simpleExampleFunctionWithDefaultValues(argument1: String = "", argument2: String = ""): String {
    return argument1 + argument2
}

fun addAll(first: Int, second: Int, third: Int = 0, fourth: Int = 0): Int {
    return first + second + third + fourth
}

fun addAllInOneLinerSyntax(first: Int, second: Int, third: Int = 0, fourth: Int = 0) = first + second + third + fourth

/**
 * Task functionSyntax
 * Define a function addAll that takes 4 integers (Type Int in Kotlin) as input and returns the sum.
 * Try the normal function definition syntax and also the one-liner syntax.
 */
private fun functionSyntaxTask() {
    println("#### Task shortFunctionSyntaxTask: Should print 6")

    println(addAll(0, 1, 2, 3));
}


/**
 * Task callingFunctionsWithNamedArguments
 * "addAll" has many arguments. Theoretically one could mix up the order when calling the function. Replace the invocation above with an invocation with named arguments.
 * You can also play around and mix positional and named arguments to see what happens.
 */
private fun callingFunctionsWithNamedArgumentsTask() {
    println("#### Task shortFunctionSyntaxTask: Should print 6")

    println(addAll(first = 0, second = 1, third = 2, fourth = 3))
}


/**
 * Task defaultValues
 * It would also make sense to call "addAll" with 2 or 3 arguments. Add default values for c and d such that the code below compiles and prints the desired results
 */
private fun defaultValues() {
    println("#### Task shortFunctionSyntaxTask: Should print 1 and 3")

    println(addAll(0, 1))
    println(addAll(0, 1, 2))
}