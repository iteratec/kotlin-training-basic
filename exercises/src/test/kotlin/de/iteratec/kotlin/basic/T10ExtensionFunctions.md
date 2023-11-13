# Extension functions

## Basic syntax

Kotlin allows us to define methods for classes, we do not necessarily own, from outside (so-called extension functions).
However they are implemented behind the scenes with static methods of Utility classes.
Hence polymorphism and overriding existing methods is not possible.

```kotlin
fun ReceiverType.functionName(arg: Argument): ReturnType {
    // Body
}

val receiver: ReceiverType = ReceiverType()
receiver.functionName(Argument())
```

One use-case is the following: Java and hexagonal architecture prohibit the following code:
```kotlin
myDomainObject.convertToPersistenceObject()
```
<b> convertToPersistenceObject </b> clearly has a dependency to the persistence layer (the return type), therefore it cannot be defined in the Domain layer.
However in Kotlin you can define it as an extension function of the domain class residing in the persistence layer package.

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

