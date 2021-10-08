# Basic function syntax

Functions can be delared in classes (instance methods - <b> this </b> is wired to the receiver) or top-level in a file (<b> this </b> is not defined) with the <b> fun </b> keyword. 

```kotlin
fun functionName(argument1: TypeOfArgument1, argument2: TypeOfArgument2): ReturnType {
    // instructions in body
    return valueToReturn
}
```

For one-liners there is the shorthand

```kotlin
fun functionName(argument1: TypeOfArgument1, argument2: TypeOfArgument2) = valueToReturn
```

# Calling a function with named arguments

For clarity, functions can not only be called with positional arguments but also with named arguments.

```kotlin
functionName(argument2 = otherArgument, argument1 = someArgument) // Equivalent to functionName(argument1, argument2)
```

# Default function arguments

+ The function
```kotlin
fun functionName(argument1: TypeOfArgument1, argument2: Int = 0): ReturnType {
    // ...
}
```
can be called in the following ways. The first two will lead to the same result.
```kotlin
functionName(arg1)
functionName(arg1, 0)

functionName(arg1, arg2)
```

