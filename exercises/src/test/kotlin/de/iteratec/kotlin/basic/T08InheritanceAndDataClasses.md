# Classes

## Inheritance

```kotlin
class Subclass(val additionalPropertyExclusiveToSubclass: Type, propertyThatWillBeDelegatedToParent: Type):
    ClassToInheritFrom(propertyThatWillBeDelegatedToParent), FurtherInterfaceToImplement {
    
        override fun functionThatInterfaceExpectsUsToImplement(): ReturnType {
            // body
        }
    }
```

Classes or interfaces you want to inherit follow the argument list of the primary constructor and ":". In case that you inherit a class, your primary constructor has to delegate to a constructor of the parent.

You supply the arguments you want to call the parent constructor with directly after the name of the parent class. Actually, this is really the syntax of a normal constructor call since there is no <b> new </b> keyword in Kotlin.

Aside from using the "fun" and "override" keyword declaring instance methods is analogous to Java.

Classes have to marked as <b> open </b> in order to be subclassable. Methods, properties have to marked as <b> open </b> in order to be overiddable.

## Data classes

Data classes are classes for which <b> hashCode, equals, toString </b>, destructuring and a copy-function are auto-implemented. For all those things a data class uses the properties (arguments prefixed by <b> val/var </b>) provided in the primary constructor argument list.

```kotlin
data class Example(val content: String)
```

## Other remarks

As in Java you can assign visibility modifiers to properties and methods. By default everything is public.

There is the theoretical possibility to add secondary constructors to a class. I have not written any in my life and probably will never do it. Since the primary constructor can have default arguments, simple use-cases can be handled by having only the primary constructor. For use-cases more complex, prefer one of the factory patterns to secondary constructors.
