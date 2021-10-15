Required knowledge: Variables

# Strings

## String interpolation

In a string, expressions inside a <b> ${...} </b> - block are evaluated and converted to string.

```kotlin
println("Fünfunddreißig ${7 * 5}") // will print "Fünfunddreißig 35" to the console.
```

## Multi-line string

Multiline strings are strings that span multiple lines. They are built by enclosing them with triple quotes (<b> """ </b> ... <b> """ </b>). Line breaks and most symbols like quotes do not need to be escaped.

```kotlin
printlln("""
Lieber Shop-Kunde,

ihre Bestellung wird vespätet eintreffen, da gerade alle außer mir im Urlaub sind.

Auf bald, ihr "Shop-Support-Buddy"
""") // will print those 5 lines to the console
```

