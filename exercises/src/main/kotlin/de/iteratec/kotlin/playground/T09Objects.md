# Objects, companion object and static methods

## Objects

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

## Static methods and objects 

There are no static methods in Kotlin. Rather a class can have a companion object. That is basically a singleton instance of a class that is accessible under the same name as the origin class itself. 
You can use its methods/properties without an instance of the origin class (like static properties/methods in Java). Instances of your origin class see the methods/properties of the companion object and can interact with them.