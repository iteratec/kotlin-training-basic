Required knowledge: Extension functions, classes

# Extension properties

Aside from extension functions, you can also add a property to an existing class, a so-called extension property. As the class itself in the bytecode will not be changed,
you cannot create a new backing field for your new property. This means you are forced to override getter and setter.  

```kotlin
class MutableCircle(var radius: Double)
var MutableCircle.diameter: Double
    get() = radius * 2
    set(value) {
        radius = value / 2
    }
```

# Operator overloading

Many Kotlin operators are implemented with functions and the <b> operator </b> keyword. Doing this, you can use the existing operators for your own classes.

```kotlin
class Circle(var radius: Double) {
    operator fun plus(secondCircle: Circle): Circle {
        return Circle(radius + secondCircle.radius)
    }
}
val circle1 = Circle(1)
val circle2 = Circle(2)
val circle3 = circle1 + circle2 // will have radius 3
```

