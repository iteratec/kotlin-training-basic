Required knowledge: Classes

# Objects

Objects are a mix of anonymous class and the singleton pattern. Declaring an object creates a class and on the same time instantiates an instance of this class and wires the class name to be a reference to this instance.  

```kotlin
object MySingleton: ParentClassToInherit(argumentOfParentConstructor) {
    fun doSomething() {
        // ..
    }
} 

MySingleton.doSomething() // MySingleton points to the sole instance of the class
```

As objects cannot have constructors with more than 0 arguments, they are not a replacement for a dependency inversion framework. Possible use-cases are:
+ Inside a class as a companion object in order to basically mimic static methods (<b> static </b> is not a keyword in Kotlin)
+ In combination with sealed classes to form a more powerful version of an <b> enum </b>.
+ Utility class: Normally prefer top-level functions

# Sealed classes

The <b> sealed </b> keyword means that a class cannot be instantiated or sub-classed outside of the same package. Sealed classes know their children at compile-time.
It is mainly meant for parent classes that are aware of their children classes and violate the Open-Closed-principle purposefully.
Imagine, if Boolean was not a built-in, we could declare it as a sealed class with the two sub-classes True and False. We do not want others to sub-class Boolean because further sub-classes might break our implementation of lets say a "negate"-function that flips a Boolean.


```kotlin
sealed class MyBoolean {
    fun flip() {
        return if (this is True) {
            False
        } else {
            True
        }
    } // Imagine that some careless user wants to add another sub-class of MyBoolean called Maybe. He might forget to adapt the flip-method which would result in Maybe.flip()=true which seems wrong.
    // Normally you would use a when-expresion here instead of if. We show this shortly.
}

object True: MyBoolean
object False: MyBoolean
```

# When

The <b> when </b> keyword is a better version of a <b> switch </b> statement being far more flexible and not having the fall-through mechanism. They are most powerful when used branching on a reference of an enum or sealed class.

```kotlin
// Using the sealed class from above
fun flip() {
    return when (instanceOfMyBoolean) {
        is True -> False
        is False -> True // because MyBoolean is a sealed class, the compiler knows that there cannot be any other cases.
    }
}
```

<b> when </b> looks for the first match nd returns the element behind it. When <b> when </b> is used to assign a variable in this way (being used as an expression not only as a statement),
Kotlin automatically checks that your branches are exhaustive and forces you to add an else-branch if necessary. 

In <b> when </b> statements with a reference to branch on ( "()"-brackets non-empty ) sadly only certain operators can be used to declare the branching conditions (class membership, membership in a collection, equality check, ...). For more flexible use <b> when </b> without a reference to branch on.   

```kotlin
when {
    someBooleanExpression1, 
    someBooleanExpression2 -> elementToReturnInTheseBranches
    someBooleanExpression3 -> elementToReturnInThisBranch
    else -> elementToReturnWhenNothingElseMatches
}
```




