# Classes

## Basic syntax

```kotlin
class Example(val readonlyPropertyOfClass: Type, var mutablePropertyOfClass: Type, furtherArgumentOfPrimaryConstructor: Type):
    ClassToInheritFrom(firstArgumentOfParentConstructorToUse = furtherArgumentOfPrimaryConstructor), FurtherInterfaceToImplement {
        
        // This is a property declaration and an assignment. The latter one becomes part of the body of the primary constructor.
        val anotherPropertyOfClass: String = "example"
    
        init {
            println("This initialization block becomes part of the body of the primary constructor")        
        }
    
        // Unlike methods in Java, methods in Kotlin need the "fun" keyword
        fun normalMethodLikeInJava(): ReturnType {
            // body
        }
    
        override fun functionThatInterfaceExpectsUsToImplement(): ReturnType {
            // body
        }
    
        companion object {
            val iBehaveLikeAStaticPropertyOfExampleClass = "static example"
            
            fun iBehaveLikeAStaticMethodOfExampleClass() {
                // body
            }   
        }
    }

// There is no "new" keyword in Kotlin for instantiating a class
val instance = Example(arg1, arg2, arg3)

// Invoking the getter
instance.readonlyPropertyOfClass

// Invoking the setter
instance.mutablePropertyOfClass = something
```

When declaring a class, the class name is directly followed by the argument signature of the primary constructor (the list of arguments in round brackets).

Assignments in property declarations and all init blocks in the class body form the body of the primary constructor.

There are two types of properties in a Kotlin class:
For mutable properties (declare as <b>var readOnlyProperty: Type</b>) Kotlin generates a private backing field holding the value, a getter and a setter. 
For read-only properties (declare as <b>val mutableProperty: Type</b>) Kotlin generates a private backing field holding the value and a getter. A setter is not provided.

Getters and setters are used behind the scenes, but Kotlin makes us feel like we work with the raw property.
<b>instance.property</b> invokes the getter of <b>property</b>. <b>instance.property = something</b> invokes the setter of <b>property</b>.

There is the possibility to implement the getter and setter by yourself but it is rarely needed.

Kotlin automatically creates properties from the primary constructor signature for those arguments prefixed with <b> val/var </b> and assigns them with the right values on the constructor call. 

Constructor arguments not prefixed with <b> val/var </b> are only available in the body of the primary constructor but not in methods since they dont have a backing field.

Classes or interfaces you want to inherit follow the argument list of the primary constructor and ":". In case that you inherit a class, your primary constructor has to delegate to a constructor of the parent.

You supply the arguments you want to call the parent constructor with directly after the name of the parent class. Actually, this is really the syntax of a normal constructor call since there is no <b> new </b> keyword in Kotlin.

Aside from using the "fun" and "override" keyword declaring instance methods is analogous to Java.

There are no static methods in Kotlin. Rather a class can have a companion object. That is basically a singleton instance of a class that is accessible under the same name as the origin class itself. 
You can use its methods/properties without an instance of the origin class (like static properties/methods in Java). Instances of your origin class see the methods/properties of the companion object and can interact with them.

As in Java you can assign visibility modifiers to properties and methods. By default everything is public.

There is the theoretical possibility to add secondary constructors to a class. I have not written any in my life and probably will never do it. Since the primary constructor can have default arguments, simple use-cases can be handled by having only the primary constructor. For use-cases more complex, prefer one of the factory patterns to secondary constructors.

## Data classes

Data classes are classes for which <b> hashCode, equals, toString </b>, destructuring and a copy-function are auto-implemented. For all those things a data class uses the properties (arguments prefixed by <b> val/var </b>) provided in the primary constructor argument list.

```kotlin
data class Example(val content: String)
```

## Final and class inheritance

By default, classes itself, are final. If you want to allow them to be extended, mark them with the "open" keyword. 
