# Variable declaration and type-inference

Variables can be declared with the keyword <b> var </b> (mutable) or <b> val </b> (read-only; similar to <b> final </b> in Java. The <b> final </b> keyword in Kotlin means only that things cannot be overridden).
The type of a variable is declared after the variable name. The is optional in case that the assignment is made on the same line. Then Kotlin auto-infers the type.

```kotlin
val readOnlyVariable: String = "iAmConstant" // Cannot be reassigned
var mutableVariable = "iCouldBeReassigned" // Type String is auto-inferred
mutableVariable = "somethingElse" // Redeclaration is allowed
```

# Expressions

In Kotlin, constructs like <b> if </b> or <b> try </b> are expressions, meaning they return a value (typically the result of the expression last evaluated inside the construct) and can be assigned to a variable.



