# Lambdas and function types

## Syntax

In contrast to Java, lambdas are first-level citizen. They can be saved in variables and passed around. A lambda expecting N arguments (where N could also be 0) is of the function type
<b> (ArgumentType1, ..., ArgumentTypeN) -> ReturnType </b>.

The body of a lambda can contain multiple instructions. The result of the last expression evaluated gets returned by the lambda automatically.

```kotlin
val myLambda: (Type1, Type2) -> String = {
    inputArgument1: Type1, inputArgument2: Type2 -> 
    // doSomething
    "iAmTheLastLineEvaluatedAndGetReturnedAutomatically"
}

myLambda() // Invoking the lambda
```

Most times you create a lambda directly as a function argument in a function call expecting a lambda.
In that case, the type of the arguments of the lambda are normally auto-inferred and can be omitted. 

For a lambda with only one inputArgument (whose type is known) there is the shorthand <b> it </b> for this argument making it possible to omit the arguments at all.

```kotlin
val myLambda: (String) -> Int = {
    it.length
}

myLambda() // Invoking the lambda
```

When invoking a function expecting a lambda as the last argument, there is a Kotlin convention moving the lambda out of the argument list brackets.

```kotlin
val myString = "h a l l o"
myString.filter({ it.isWhitespace() }) // will give "hallo"
myString.filter{ it.isWhitespace() } // will give "hallo", preferred syntax
```

## let and null safety

<b>let</b> can be called on any object and takes a lambda with that object as single argument as input.
Basically <b> something.let{ lambda } </b> is the same as <b>lambda(something)</b>.
When combining let with a safe call <b>?.</b> (i.e. <b>?.let</b>) or even the Elvis operator one can make a very concise null check.

```kotlin
val nullAsString: String? = null
nullAsString?.let { it.length } // is null - The lambda inside let expects a non-nullable string and is not called. 
nullAsString?.let { it.length } ?: 0 // is 0 - The lambda inside let expects a non-nullable string and is not called. 
"hallo"?.let { it.length } // is 5 - The lambda inside let expects a non-nullable string and is called.
```