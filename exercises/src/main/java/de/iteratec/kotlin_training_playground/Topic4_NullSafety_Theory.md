# Null safety

In Kotlin, variables of a type "Type" cannot be assigned to null (compilation error). Variables declared as "Type?" can hold a real instance of Type or null.

```kotlin
val notNull: String = null // will not compile
val possibleNull: String? = null
```

## Null checks

The safe call operator <b> ?. </b> calls a method on a nullable instance in case that the instance is not <b> null </b> and returns <b> null </b> otherwise. It can be used together with the Elvis operator <b> ?: </b> in order to set a default value if the receiver of the method is null.

```kotlin
var nullDisguisedAsString: String? = null
var reallyAString: String? = "h"

nullDisguisedAsString?.length // will be null
reallyAString.length // will be 1

nullDisguisedAsString?.length ?: 0 // will be 0
reallyAStringg?.length ?: 0 // will be 1

// Chaining is possible
nullDisguisedAsString?.plus("a")?.plus("l")?.plus("l")?.plus("o") ?: "" // will be ""
reallyAString?.plus("a")?.plus("l")?.plus("l")?.plus("o") ?: "" // will "hallo"
```

There are further options for null checks by using <b> let </b> and <b> extension functions </b> that we will explore later.

## Interoperability with Java

As Java is not null safe, Kotlin cannot know in all cases whether a function call from Java is null-safe. The compiler will not execute any null checks when assigning objects obtained from Java classes to null-safe variables. At runtime, it will execute a null check when assigning the variable and fail with a NullPoinerException.

Kotlin has an internal type (platform type: <b> Type! </b> instead of <b> Type </b>) for objects retrieved from Java classes that could be null. 

One can use the @NotNull, @Nullable annotations in Java classes to help Kotlin calling those and automatically avoid platform types.  

## Casting

In case you have a nullable variable and you are sure that it cannot be null, you can cast it with <b> !! </b> to be treated as non-nullable. 
Sometimes (for instance after a successfull null check), a cast is not necessary and done behind the scenes by Kotlin.

```kotlin
val couldBeNull: String? = "example"
val cannotBeNull: String = couldBeNull!!
```
