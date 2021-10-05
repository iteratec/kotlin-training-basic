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



