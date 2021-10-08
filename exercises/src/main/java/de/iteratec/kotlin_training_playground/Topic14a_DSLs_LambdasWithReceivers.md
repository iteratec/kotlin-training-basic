Required knowledge: Extension functions, lambdas, classes

# Lambdas with receivers

## Basic syntax

Similar to extension functions, Kotlin allows lambdas to be called on a receiver.
Lambdas with receivers feel like instance methods (without polymorphism) while ordinary lambdas feel like static methods. 
Lambdas with receiver cannot be called without receiver. They are particular useful in order to write type-safe concise DSLs.

```kotlin
val lambdaWithReciever: String.(Int) -> Int  = {
    this.length * it // this refers to the receiver, it referes to the argument
}

"Achim".lambdaWithReciever(2) // will be 10
```



