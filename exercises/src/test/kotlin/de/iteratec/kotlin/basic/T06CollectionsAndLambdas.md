# Collections and lambdas

## Lambdas

### Syntax

Kotlin supports functional-programming style by supplying functions as arguments to other functions. Functions can be passed in the following form
as an argument:
+ Implementations of SAM interfaces (= single abstract method interface; exists also in Java)
+ function types

Usually one uses so-called lambdas functions or method references which are converted to one of the upper by the compiler automatically.

The <b>filter</b>-method of the <b>String</b>-class takes a function of signature <b> Char -> Boolean </b> as an input 
and returns the string that is obtained by keeping only the <b>char</b>acters that the input function evaluates to <b>true</b>  
```kotlin
val myString = "h a l l o"
// all the following calls are equivalent and return the string "hallo"
myString.filter(Char::isWhitespace) // method reference: the parameterless function isWhitespace with receiver is automatically converted to a receiverless function with one parameter.
myString.filter({ letter: Char -> letter.isWhitespace()}) // an ordinary lambda function as argument. The expression on the right of the arrow is returned automatically
myString.filter({ letter -> letter.isWhitespace()}) // input types of lambda functions can often be auto-inferred
myString.filter({ it.isWhitespace() }) // if the lambda function has only one input parameter of aut-inferred type, you can refer to it as "it" without declaring it
myString.filter(){ it.isWhitespace() } // as a convention, if the last parameter of a function invocation is a lambda, it should be taken out of the argument list
myString.filter { it.isWhitespace() } // if the function invocation has only 1 lambda as argument, we can even remove the argument brackets 
```

# Collections

The Collection-type hierarchy of Kotlin is very analogeous to Java and Kotlin uses the Java implementations under the hood. The main difference is that Kotlin offers mutable and immutable versions of most collections.
Java collections can automatically be used in place of Kotlin collections and vice versa. The conversion from Java collection to Kotlin collections is done by the compiler under the hood. 

## Mutability

In Kotlin, normally collections are treated as immutable. So you cannot add something to an instance of <b> List&lt;String&gt; </b>.
All collections have mutable sub-classes/sub-interfaces which offer these methods. For <b> List </b> this would be <b> MutableList </b>.
Note though that a variable of type <b> List </b> is not truly immutable. Somebody else could have a variable of type <b> MutableList </b> pointing to the same object.

## Instantiation

Kotlin offers factory methods to generated collections like

```kotlin
// immutable
emptyList()
listOf("hallo", "goodbye")

// mutable
mutableListOf()
mutableListOf("hallo", "goodbye")
```

## Streaming-API

In Kotlin, it is rarely needed to make use of the Java-Streaming-API. Methods like filter, map, reduce can be called on Iterables directly and Kotlin added many more. 
Similar to Java, you use those functions with a lambda as an argument.

```kotlin
listOf("hallo", "goodbye").filter{ it.length > 5 } // will equal listOf("goodbye")
```

For performance-critical tasks where short-circuiting is needed you can use Java streams or Kotlin sequences.


