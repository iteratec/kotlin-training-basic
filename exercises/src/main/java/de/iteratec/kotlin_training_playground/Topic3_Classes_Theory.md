# Classes

## Basic syntax

```kotlin
class Example(val automaticallyGeneratedReadonlyPropertyOfClass: Type, var automaticallyGeneratedMutablePropertyOfClass: Type, furtherArgumentOfPrimaryConstructor: Type) {
        // This is a property declaration and an assignment. The latter one becomes part of the body of the primary constructor.
        val anotherPropertyOfClass: Type = furtherArgumentOfPrimaryConstructor
    
        init {
            println("This initialization block becomes part of the body of the primary constructor")        
        }
    
        fun normalMethodLikeInJava(): ReturnType {
            // body
        }
    }

// There is no "new" keyword in Kotlin for instantiating a class
val instance = Example(arg1, arg2, arg3)

// Invoking the getter
instance.automaticallyGeneratedReadonlyPropertyOfClass

// Invoking the setter
instance.automaticallyGeneratedMutablePropertyOfClass = something
```

When declaring a class, the class name is directly followed by the argument signature of the primary constructor (the list of arguments in round brackets).

Assignments in property declarations and all init blocks in the class body form the body of the primary constructor.

There are two types of properties in a Kotlin class:
For mutable properties (declare as <b>var readOnlyProperty: Type</b> in class body) Kotlin generates a private backing field holding the value, a getter and a setter. 
For read-only properties (declare as <b>val mutableProperty: Type</b> in class body) Kotlin generates a private backing field holding the value and a getter. A setter is not provided.

Getters and setters are used behind the scenes, but Kotlin makes us feel like we work with the raw property.
<b>instance.property</b> invokes the getter of <b>property</b>. <b>instance.property = something</b> invokes the setter of <b>property</b>.

There is the possibility to implement the getter and setter by yourself but it is rarely needed.

Kotlin automatically creates properties from the primary constructor signature for those arguments prefixed with <b> val/var </b> and assigns them with the right values on the constructor call. 

Constructor arguments not prefixed with <b> val/var </b> are only available in the body of the primary constructor but not in methods since they dont have a backing field.