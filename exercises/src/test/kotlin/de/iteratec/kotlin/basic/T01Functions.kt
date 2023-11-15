package de.iteratec.kotlin.basic

/**
# Functions & main function
Requirements: none

Things to discuss:
- Java to Kotlin Converter in IntelliJ (Right click on File -> Convert Java file to Kotlin file)
- Inspect Kotlin bytecode and decompiled Java class
    - Shift, Shift -> Show Kotlin Bytecode -> Decompile
    - Tools -> Kotlin -> Show Kotlin Bytecode -> Decompile
- Comparison with main-function in Java
- Explain function syntax and Unit in Kotlin
- Invocation with positional or named arguments
- One-liner syntax
- Default values
 */
fun main(args: Array<String>): Unit {
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
}

fun simpleExampleFunction(argument1: String, argument2: String): String {
    return argument1 + argument2
}

fun simpleExampleFunctionInOneLinerSyntax(argument1: String, argument2: String) = argument1 + argument2

fun simpleExampleFunctionWithDefaultValues(argument1: String = "", argument2: String = ""): String {
    return argument1 + argument2
}
